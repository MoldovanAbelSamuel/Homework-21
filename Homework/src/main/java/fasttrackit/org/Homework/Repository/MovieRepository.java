package fasttrackit.org.Homework.Repository;

import fasttrackit.org.Homework.Domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer>  {

}
