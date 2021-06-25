package ro.sda.movie_reservation_system.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projection_rooms")
public class ProjectionRooms extends GenericEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Seats")
    private int seats;

    @Enumerated(EnumType.STRING)
    @Column(name = "Availability")
    private Builder.AvailabilityEnum availability;
    public enum AvailabilityEnum {Y, N}

    @OneToMany(mappedBy = "projectionRooms",
            cascade = CascadeType.ALL)
    private List<Booking> bookingList;

    public ProjectionRooms() {}

    public static class Builder extends GenericEntity {
        private int id;
        private String name;
        private int seats;
        private AvailabilityEnum availability;
        public enum AvailabilityEnum {Y,N}

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder seats(int seats){
            this.seats = seats;
            return this;
        }

        public Builder availability(AvailabilityEnum availability){
            this.availability = availability;
            return this;
        }

        public ProjectionRooms build(){
            ProjectionRooms projectionRooms = new ProjectionRooms();
            projectionRooms.id = this.id;
            projectionRooms.name = this.name;
            projectionRooms.seats = this.seats;
            projectionRooms.availability = this.availability;
            return projectionRooms;
        }

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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Builder.AvailabilityEnum getAvailability() {
        return availability;
    }

    public void setAvailability(Builder.AvailabilityEnum availability) {
        this.availability = availability;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public ProjectionRooms(int id, String name, int seats, Builder.AvailabilityEnum availability) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        this.availability = availability;
    }
}