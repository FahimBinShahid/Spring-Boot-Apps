package movie.list.MovieChart.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Rating {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "movie_id")
        private Movies movie;

        private int rating;
        private LocalDateTime reviewDate;
        private String reviewer;
    }


