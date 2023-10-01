package fasttrackit.org.Homework.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;
    private String text;
    private String reviewer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "movie_id")
    private Movie movieReview;

    public Review(Integer reviewId, String text, String reviewer, Movie movieReview) {
        this.reviewId = reviewId;
        this.text = text;
        this.reviewer = reviewer;
        this.movieReview = movieReview;
    }

    public Review(String text, String reviewer, Movie movieReview) {
        this.text = text;
        this.reviewer = reviewer;
        this.movieReview = movieReview;
    }

    public Review() {
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Movie getMovieReview() {
        return movieReview;
    }

    public void setMovieReview(Movie movieReview) {
        this.movieReview = movieReview;
    }
}
