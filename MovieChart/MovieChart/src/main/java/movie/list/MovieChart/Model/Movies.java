package movie.list.MovieChart.Model;

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
    private int rating;
    private String description;
    private String releaseDate;
    private String ratingType;

//    @OneToMany(mappedBy = "movie")
//    private List<Rating> ratings;

}