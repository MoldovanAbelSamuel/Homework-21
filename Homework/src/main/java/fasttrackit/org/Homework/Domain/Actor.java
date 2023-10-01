package fasttrackit.org.Homework.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer actorId;
    private String actorName;
    private int birthYear;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private List<Movie> movies;

    public Actor(String actorName, int birthYear) {
        this.actorName = actorName;
        this.birthYear = birthYear;
    }

    public Actor(Integer actorId, String actorName, int birthYear) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.birthYear = birthYear;
    }

    public Actor() {
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor actor)) return false;
        return getBirthYear() == actor.getBirthYear() && Objects.equals(getActorId(), actor.getActorId()) && Objects.equals(getActorName(), actor.getActorName()) && Objects.equals(getMovies(), actor.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActorId(), getActorName(), getBirthYear(), getMovies());
    }

    public void addMovie(Movie movie){
        if(this.movies == null){
            this.movies = new ArrayList<>();
        }
        this.movies.add(movie);
    }
}
