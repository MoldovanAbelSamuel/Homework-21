package fasttrackit.org.Homework;

import fasttrackit.org.Homework.Domain.Movie;
import fasttrackit.org.Homework.Domain.MovieRating;
import fasttrackit.org.Homework.Domain.Review;
import fasttrackit.org.Homework.Domain.Studio;
import fasttrackit.org.Homework.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Bean
	CommandLineRunner atStartup(MovieRepository movieRepository, MovieRatingRepository movieRatingRepository,
								ReviewRepository reviewRepository, StudioRepository studioRepository,
								ActorRepository actorRepository){
		return args -> {
			Movie m1 = new Movie("m1", 2000);
			Movie m2 = new Movie("m2", 2001);
			Movie m3 = new Movie("m3", 2002);
			Movie m4 = new Movie("m4", 2003);
			Movie m5 = new Movie("m5", 2004);
			/*movieRepository.save(m1);
			movieRepository.save(m2);
			movieRepository.save(m3);*/
			movieRepository.save(m4);
			movieRepository.save(m5);
			MovieRating mr1 = new MovieRating(5, "test", m3);
			//movieRatingRepository.save(mr1);
			m3.setMovieRating(mr1);
			//movieRepository.save(m3);
			Review r1 = new Review("test 1", "r1", m2);
			Review r2 = new Review("test 2", "r3", m2);
			Review r3 = new Review("test 3", "r2", m2);
			Review r4 = new Review("test 4", "r4", m3);
			m2.addReview(r1);
			m2.addReview(r2);
			m2.addReview(r3);
			m3.addReview(r4);
			//movieRepository.save(m2);
			//movieRepository.save(m3);
			List<Movie> newList = new ArrayList<>();
			newList.add(m1);
			newList.add(m2);
			newList.add(m3);
			Studio s1 = new Studio("s1", "asdasc", newList);
			m1.setStudioMovie(s1);
			m2.setStudioMovie(s1);
			m3.setStudioMovie(s1);
			studioRepository.save(s1);
		};
	}

}
