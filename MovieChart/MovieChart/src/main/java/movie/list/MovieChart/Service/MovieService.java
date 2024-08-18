package movie.list.MovieChart.Service;

import movie.list.MovieChart.Model.Movies;
import movie.list.MovieChart.Model.Rating;
import movie.list.MovieChart.Repository.MovieRepository;
import movie.list.MovieChart.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {



    @Autowired
    private MovieRepository movieRepository;

    public MovieService(RatingRepository ratingRepository) {
    }

    public List<Movies> getMoviesSortedByRating() {
        List<Movies> movies = movieRepository.findAll();

        Comparator<Movies> ratingComparator = Comparator.comparingInt(Movies::getRating).reversed();

        movies.sort(ratingComparator);

        return movies;
    }


    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movies getMovieById(int id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Movie not found with id " + id));
    }


    public void addMovie(Movies movie) {
        movieRepository.save(movie);
    }


    public void updateMovie(int id, Movies movieDetails) {
        Movies movie = getMovieById(id);
        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setDirector(movieDetails.getDirector());
        movie.setYear(movieDetails.getYear());
        movie.setRuntime(movieDetails.getRuntime());
        movie.setDescription(movieDetails.getDescription());
        movie.setRating(movieDetails.getRating());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setRatingType(movieDetails.getRatingType());
        movieRepository.save(movie);
    }


    public void deleteMovie(int id) {
        Movies movie = getMovieById(id);
        movieRepository.delete(movie);
    }


}
