package movie.list.MovieChart.Controller;

import movie.list.MovieChart.Model.Entities.Movies;
import movie.list.MovieChart.Model.Entities.Rating;
import movie.list.MovieChart.Model.Request.RatingUpdateRequest;
import movie.list.MovieChart.Service.MovieService;
import movie.list.MovieChart.Service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {


    private final MovieService movieService;

    private final RatingService ratingService;

    public MoviesController(MovieService movieService, RatingService ratingService) {
        this.movieService = movieService;
        this.ratingService = ratingService;
    }


    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/sorted-by-rating")
    public ResponseEntity<List<Movies>> getMoviesSortedByRating() {
        List<Movies> movies = movieService.getMoviesSortedByRating();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable int id) {
        Movies movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movies movie) {
        movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movie added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable int id, @RequestBody Movies movieDetails) {
        movieService.updateMovie(id, movieDetails);
        return ResponseEntity.ok("Movie updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }

    @PostMapping("/{id}/ratings")
    public ResponseEntity<Rating> addMovieRating(@PathVariable int id, @RequestBody Rating rating) {
        Rating newRating = ratingService.addRating(id, rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
    }

    @GetMapping("/{id}/ratings")
    public ResponseEntity<List<Rating>> getRatingsByMovie(@PathVariable int id) {
        List<Rating> ratings = ratingService.getRatingsByMovie(id);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }


    @GetMapping("/{id}/ratings/{ratingId}")
    public ResponseEntity<Rating> getRatingByMovieId(@PathVariable int id, @PathVariable int ratingId) {
        return ResponseEntity.ok(ratingService.getRatingById(id, ratingId));
    }


    @PutMapping("/{id}/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable int id, @PathVariable int ratingId, @RequestBody RatingUpdateRequest ratingUpdateRequest) {
        Rating updatedRating = ratingService.updateRating(id, ratingId, ratingUpdateRequest);
        return ResponseEntity.ok(updatedRating);
    }


    @DeleteMapping("/{id}/ratings/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable int id, @PathVariable int ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/average-rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable int id) {
        return new ResponseEntity<>(ratingService.calculateAverageRating(id), HttpStatus.OK);
    }


}
