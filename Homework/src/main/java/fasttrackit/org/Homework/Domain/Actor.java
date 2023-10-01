package fasttrackit.org.Homework.Domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

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
    private Set<Movie> movies;

    public Actor(Integer actorId, String actorName, int birthYear, Set<Movie> movies) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.birthYear = birthYear;
        this.movies = movies;
    }

    public Actor(String actorName, int birthYear, Set<Movie> movies) {
        this.actorName = actorName;
        this.birthYear = birthYear;
        this.movies = movies;
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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
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
}
