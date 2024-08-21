package movie.list.MovieChart.Service;
import movie.list.MovieChart.Model.Entities.Movies;
import movie.list.MovieChart.Repository.MovieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movies> getMoviesSortedByRating() {
        return movieRepository.findAll(Sort.by(Sort.Order.desc("rating")));
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
        updateMovieDetails(movie, movieDetails);
        movieRepository.save(movie);
    }

    public void deleteMovie(int id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Movie not found with id " + id);
        }
    }

    private void updateMovieDetails(Movies movie, Movies movieDetails) {
        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setDirector(movieDetails.getDirector());
        movie.setYear(movieDetails.getYear());
        movie.setRuntime(movieDetails.getRuntime());
        movie.setDescription(movieDetails.getDescription());
        movie.setRating(movieDetails.getRating());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setRatingType(movieDetails.getRatingType());
    }
}
