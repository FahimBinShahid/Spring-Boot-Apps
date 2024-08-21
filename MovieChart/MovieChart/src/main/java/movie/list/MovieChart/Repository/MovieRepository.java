package movie.list.MovieChart.Repository;

import movie.list.MovieChart.Model.Entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

    }


