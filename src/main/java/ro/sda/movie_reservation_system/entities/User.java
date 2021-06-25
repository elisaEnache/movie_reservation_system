package ro.sda.movie_reservation_system.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends GenericEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Booking> bookingList;


    public User() {
    }

  //TODO Builder Constructor
//   public static class UserBuilder{
//        private int id;
//        private String name;
//        private String email;
//        private String password;
//
//        public UserBuilder id(int id){
//            this.id = id;
//            return this;
//        }
//
//        public UserBuilder name(String name){
//            this.name = name;
//            return this;
//        }
//
//        public UserBuilder email(String email){
//            this.email = email;
//            return this;
//        }
//        public UserBuilder password(String password){
//            this.password = password;
//            return this;
//        }
//
//        public User build (){
//            User user = new User();
//            user.id = id;
//            user.name = name;
//            user.email = email;
//            user.password = password;
//            return user;
//        }
//  }
//    public static UserBuilder builder(){
//        return new UserBuilder();
//    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
