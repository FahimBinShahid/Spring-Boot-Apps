package movie.list.MovieChart.Service;

import movie.list.MovieChart.Model.Entities.Movies;
import movie.list.MovieChart.Model.Entities.Rating;
import movie.list.MovieChart.Model.Request.RatingUpdateRequest;
import movie.list.MovieChart.Repository.RatingRepository;
import movie.list.MovieChart.Repository.MovieRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;

    public RatingService(RatingRepository ratingRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
    }


    public Rating addRating(int movieId, Rating rating) {
        Movies movie = findMovieById(movieId);
        rating.setMovie(movie);
        return ratingRepository.save(rating);
    }

    public Rating updateRating(int movieId, int ratingId, RatingUpdateRequest ratingUpdateRequest) {
        Rating existingRating = findRatingById(ratingId);
        existingRating.setRating(ratingUpdateRequest.getRating());
        return ratingRepository.save(existingRating);
    }


    public void deleteRating(int ratingId) {
        if (ratingRepository.existsById(ratingId)) {
            ratingRepository.deleteById(ratingId);
        } else {
            throw new ResourceNotFoundException("Rating with ID " + ratingId + " not found.");
        }
    }

    public List<Rating> getRatingsByMovie(int movieId) {
        List<Rating> ratings = ratingRepository.findByMovieId(movieId);
        if (ratings.isEmpty()) {
            throw new ResourceNotFoundException("No ratings found for movie with ID " + movieId);
        }
        return ratings;
    }

    public Rating getRatingById(int movieId, int ratingId) {
        Rating rating = findRatingById(ratingId);
        if (rating.getMovie() == null || rating.getMovie().getId() != movieId) {
            throw new ResourceNotFoundException("Rating with ID " + ratingId + " does not belong to movie with ID " + movieId);
        }
        return rating;
    }

    private Movies findMovieById(int movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with ID " + movieId + " not found."));
    }


    private Rating findRatingById(int ratingId) {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new ResourceNotFoundException("Rating with ID " + ratingId + " not found."));
    }
}
