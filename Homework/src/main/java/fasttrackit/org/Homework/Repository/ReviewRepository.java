package fasttrackit.org.Homework.Repository;

import fasttrackit.org.Homework.Domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
