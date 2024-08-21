package movie.list.MovieChart.Model.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Rating {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int id;

            private int rating;

            private String reviewer;

            @CreationTimestamp
            private LocalDateTime ratedAt;

            @UpdateTimestamp
            private LocalDateTime updatedAt;

            @ManyToOne
            @JsonBackReference
            @JoinColumn(name = "movie_id")
            private Movies movie;



    }


