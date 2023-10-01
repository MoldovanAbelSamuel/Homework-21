package fasttrackit.org.Homework.Domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Studio")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private Integer studioId;
    private String studioName;
    private String studioAddress;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "studioMovie")
    private List<Movie> movies;

    public Studio(Integer studioId, String studioName, String studioAddress, List<Movie> movies) {
        this.studioId = studioId;
        this.studioName = studioName;
        this.studioAddress = studioAddress;
        this.movies = movies;
    }

    public Studio(String studioName, String studioAddress, List<Movie> movies) {
        this.studioName = studioName;
        this.studioAddress = studioAddress;
        this.movies = movies;
    }

    public Studio() {
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getStudioAddress() {
        return studioAddress;
    }

    public void setStudioAddress(String studioAddress) {
        this.studioAddress = studioAddress;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        if(this.movies == null){
            this.movies = new ArrayList<>();
        }
        this.movies.add(movie);
    }
}
