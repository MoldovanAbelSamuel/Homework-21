package fasttrackit.org.Homework.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;
    private String movieName;
    private int releaseYear;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_rating_id")
    private MovieRating movieRating;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "movieReview")
    private List<Review> reviews;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studio_id")
    private Studio studioMovie;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movies_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    public Movie(Integer movieId, String movieName, int releaseYear, MovieRating movieRating, List<Review> reviews, Studio studioMovie, List<Actor> actors) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.studioMovie = studioMovie;
        this.actors = actors;
    }

    public Movie(String movieName, int releaseYear, MovieRating movieRating, List<Review> reviews, Studio studioMovie, List<Actor> actors) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.studioMovie = studioMovie;
        this.actors = actors;
    }

    public Movie() {
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){
        if (this.reviews == null){
            this.reviews = new ArrayList<>();
        }
        this.reviews.add(review);
    }

    public Studio getStudioMovie() {
        return studioMovie;
    }

    public void setStudioMovie(Studio studioMovie) {
        this.studioMovie = studioMovie;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
