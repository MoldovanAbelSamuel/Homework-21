package fasttrackit.org.Homework;

import fasttrackit.org.Homework.Domain.*;
import fasttrackit.org.Homework.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			MovieRating mr1 = new MovieRating(5, "Ag1");
			MovieRating mr2 = new MovieRating(3, "Ag2");
			MovieRating mr3 = new MovieRating(4, "Ag3");
			MovieRating mr4 = new MovieRating(5, "Ag2");

			Review r1 = new Review("test 1", "r1");
			Review r2 = new Review("test 2", "r1");
			Review r3 = new Review("test 3", "r2");
			Review r4 = new Review("test 4", "r1");

			List<Review> reviews1 = new ArrayList<>();
			reviews1.add(r1);
			reviews1.add(r2);

			List<Review> reviews2 = new ArrayList<>();
			reviews2.add(r3);
			reviews2.add(r4);

			Studio s1 = new Studio("studio 1", "address 1");
			Studio s2 = new Studio("studio 2", "address 2");
			Studio s3 = new Studio("studio 3", "address 3");

			Actor A1 = new Actor("A1", 1998);
			Actor A2 = new Actor("A2", 1995);
			Actor A3 = new Actor("A3", 1999);
			Actor A4 = new Actor("A4", 1980);




			Movie m1 = new Movie("m1", 2000, mr1, reviews1, s1, List.of(A1, A2, A3));
			mr1.setMovie(m1);
			r1.setMovieReview(m1);
			r2.setMovieReview(m1);
			s1.addMovie(m1);
			A1.addMovie(m1);
			A2.addMovie(m1);
			A3.addMovie(m1);


			Movie m2 = new Movie("m2", 2005, mr2, reviews2, s2, List.of(A1, A2, A4));
			mr2.setMovie(m2);
			r3.setMovieReview(m2);
			r4.setMovieReview(m2);
			s2.addMovie(m2);
			A1.addMovie(m1);
			A2.addMovie(m1);
			A4.addMovie(m1);

			movieRepository.save(m1);
			//movieRepository.save(m2); #TODO Totul merge pana aici, in momentul in care ii dau save si pe m2, actorii nu ii mai poate lua si apare eroarea - detached entity passed to persist: fasttrackit.org.Homework.Domain.Actor
			//movieRepository.save(m2);
		};
	}

}
