package ro.sda.movie_reservation_system.entities;

import javax.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking extends GenericEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "screening_id")
    private ProjectionRooms projectionRooms;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;


    public Booking() {
    }

    public static class Builder{
        private int id;
        private ProjectionRooms projectionRoom;
        private User user;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder projectionRooms(ProjectionRooms projectionRooms) {
            this.projectionRoom = projectionRooms;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;

        }

        public Booking build() {
            Booking booking = new Booking();
            booking.id = this.id;
            booking.projectionRooms = this.projectionRoom;
            booking.user = this.user;

            return booking;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectionRooms getProjectionRooms() {
        return projectionRooms;
    }

    public void setProjectionRooms(ProjectionRooms projectionRooms) {
        this.projectionRooms = projectionRooms;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", projectionRooms=" + projectionRooms +
                ", user=" + user +
                '}';
    }
}

