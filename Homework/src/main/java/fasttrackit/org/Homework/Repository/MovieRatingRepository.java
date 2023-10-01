package fasttrackit.org.Homework.Repository;

import fasttrackit.org.Homework.Domain.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRatingRepository extends JpaRepository<MovieRating, Integer>  {

}
