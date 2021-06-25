package ro.sda.movie_reservation_system.entities;


import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movies extends GenericEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Movies(String name) {
        this.name = name;
    }

    public Movies() {
    }

    public static class MoviesBuilder {
        private int id;
        private String name;

        public MoviesBuilder id(int id) {
            this.id = id;
            return this;
        }

        public MoviesBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Movies build() {
            Movies movies = new Movies();
            movies.id = this.id;
            movies.name = this.name;
            return movies;
        }
    }

    public static MoviesBuilder builder() {
        return new MoviesBuilder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

