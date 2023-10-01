package fasttrackit.org.Homework.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "MovieRating")
public class MovieRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieRating_id")
    private Integer movieRatingId;
    private int rating;
    private String agencyName;


    @OneToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    @JsonIgnore
    private Movie movie;

    public MovieRating(Integer movieRatingId, int rating, String agencyName) {
        this.movieRatingId = movieRatingId;
        this.rating = rating;
        this.agencyName = agencyName;
    }

    public MovieRating(int rating, String agencyName) {
        this.rating = rating;
        this.agencyName = agencyName;
    }

    public MovieRating() {
    }

    public Integer getMovieRatingId() {
        return movieRatingId;
    }

    public void setMovieRatingId(Integer movieRatingId) {
        this.movieRatingId = movieRatingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
