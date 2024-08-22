package movie.list.MovieChart.Model.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String genre;
    private String director;
    private int year;
    private int runtime;
    private String description;
    private String releaseDate;
    private String ratingType;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rating> ratings;

    public double getAverageRating() {
        return ratings.stream()
                .mapToDouble(Rating::getRatingValue)
                .average()
                .orElse(0.0);
    }
}