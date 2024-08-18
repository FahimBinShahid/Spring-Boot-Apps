package movie.list.MovieChart.Controller;

import movie.list.MovieChart.Model.Movies;
import movie.list.MovieChart.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;




    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        try {
            List<Movies> movies = movieService.getAllMovies();
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/sorted-by-rating")
    public ResponseEntity<List<Movies>> getMoviesSortedByRating() {
        try {
            List<Movies> movies = movieService.getMoviesSortedByRating();
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable int id) {
        try {
            Movies movie = movieService.getMovieById(id);
            return ResponseEntity.ok(movie);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movies movie) {
        try {
            movieService.addMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body("Movie added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding movie: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable int id, @RequestBody Movies movieDetails) {
        try {
            movieService.updateMovie(id, movieDetails);
            return ResponseEntity.ok("Movie updated successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found with id " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating movie: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        try {
            movieService.deleteMovie(id);
            return ResponseEntity.ok("Movie deleted successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found with id " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting movie: " + e.getMessage());
        }


        }

    }

