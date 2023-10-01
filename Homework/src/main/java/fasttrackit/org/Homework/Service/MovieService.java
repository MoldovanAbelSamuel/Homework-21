package fasttrackit.org.Homework.Service;

import fasttrackit.org.Homework.Domain.Movie;
import fasttrackit.org.Homework.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies (){
        return this.movieRepository.findAll();
    }
}
