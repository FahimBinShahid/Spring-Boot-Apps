package movie.list.MovieChart.Controller;

import movie.list.MovieChart.Model.Entities.Rating;
import movie.list.MovieChart.Model.Request.RatingUpdateRequest;
import movie.list.MovieChart.Service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Rating>> getRatingsByMovie(@PathVariable int movieId) {
        List<Rating> ratings = ratingService.getRatingsByMovie(movieId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable int ratingId) {
        Rating rating = ratingService.getRatingById(-1, ratingId);
        return ResponseEntity.ok(rating);
    }

    @PostMapping("/movie/{movieId}")
    public ResponseEntity<Rating> addRating(@PathVariable int movieId, @RequestBody Rating rating) {
        Rating newRating = ratingService.addRating(movieId, rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable int ratingId, @RequestBody RatingUpdateRequest ratingUpdateRequest) {
        Rating updatedRating = ratingService.updateRating(-1, ratingId, ratingUpdateRequest);
        return ResponseEntity.ok(updatedRating);

    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable int ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }
}
