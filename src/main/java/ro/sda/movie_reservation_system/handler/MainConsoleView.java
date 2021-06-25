package ro.sda.movie_reservation_system.handler;


import com.mysql.cj.xdevapi.SessionFactory;
import ro.sda.movie_reservation_system.entities.Booking;
import ro.sda.movie_reservation_system.entities.Movies;
import ro.sda.movie_reservation_system.entities.ProjectionRooms;
import ro.sda.movie_reservation_system.entities.User;
import ro.sda.movie_reservation_system.services.Repository;

import java.util.HashMap;
import java.util.Map;

public class MainConsoleView {
    ViewHandler viewHandler = new ViewHandler();
    KeyboardHandler keyboardHandler = new KeyboardHandler();
    //    MoviesRepository moviesRepository = new MoviesRepository();
    Repository repository = new Repository();
    Map<Integer, String> filter = new HashMap<>();
    SessionFactory sessionFactory = new SessionFactory();
    private String input = "";

    public void startApp() {
        int option = 0;
        while (option != 3) {
            System.out.println("======================================");
            System.out.println("WELCOME TO THE 21st MOVIE THEATER!");
            System.out.println("======================================");
            System.out.println("Please choose an option");
            viewHandler.printMenu(MenuTypeEnum.MAIN_MENU);
            option = keyboardHandler.readInt("Please choose an option");

            switch (option) {
                case 1:
                    System.out.println("LOGIN MENU:");
                    String email = keyboardHandler.readString("Email: ");
                    String password = keyboardHandler.readString("Password: ");
                    if (repository.checkExistingUser(email, password)) {
                        switchDashboardMenu();
                    } else {
                        System.out.println("======================================");
                        System.out.println("INVALID USER/PASS COMBINATION! PLEASE TRY AGAIN!");
                    }
                    break;
                case 2:
                    System.out.println("======================================");
                    System.out.println("INSERT YOUR INFO BELLOW:");
                    createUser();
                    break;
                case 3:
                    System.out.println("Logging out....");
                    System.out.println("GOOD BYE!....");
                    break;
            }
        }
    }


    private void switchDashboardMenu() {
        int option = 0;
        while (option != 5) {
            System.out.println("======================================");
            System.out.println("YOU ARE IN THE DASHBOARD MENU");
            System.out.println("======================================");
            viewHandler.printMenu(MenuTypeEnum.DASHBOARD_MENU);
            option = keyboardHandler.readInt("Please choose an option");
            switch (option) {
                case 1:
                    viewHandler.printMenu(MenuTypeEnum.USER_MENU);
                    input = User.class.getSimpleName();
                    crudOperationsGeneric();
                    break;
                case 2:
                    viewHandler.printMenu(MenuTypeEnum.MOVIES_MENU);
                    input = Movies.class.getSimpleName();
                    crudOperationsGeneric();

                    break;
                case 3:
                    viewHandler.printMenu(MenuTypeEnum.PROJECTION_ROOMS_MENU);
                    input = ProjectionRooms.class.getSimpleName();
                    crudOperationsGeneric();
                    break;
                case 4:
                    viewHandler.printMenu(MenuTypeEnum.RESERVATIONS);
                    input = Booking.class.getSimpleName();
                    crudOperationsGeneric();

                case 5:
                    System.out.println("LOGGING OUT.....");
                    System.out.println("HAVE A NICE DAY");
            }
        }
    }

    private void crudOperationsGeneric() {
        int option = 0;
        while (option != 6) {
            System.out.println("======================================");
            System.out.println("YOU ARE NOW OPERATION ON THE DATABASE");
            System.out.println("======================================");
            option = keyboardHandler.readInt("Please choose an option");
            switch (option) {
                case 1:
//                    TODO GET ALL
                    System.out.println(repository.getAll(input));


                    break;
                case 2:
//                    TODO: GENERIC CREATE OBJECT METHOD;
                    if (input.equals(User.class.getSimpleName())) {
                        createUser();
                    } else if (input.equals(Movies.class.getSimpleName())) {
                        createMovie();
                    } else if (input.equals(ProjectionRooms.class.getSimpleName())) {
                        createProjectionRoom();
                    } else if (input.equals(Booking.class.getSimpleName())) {
                        createBooking();
                    }
                    break;
                case 3:
//                    TODO: GENERIC FIND OBJECT BY ID METHOD;
                    repository.get(keyboardHandler.readInt("INSERT USER ID"));
                    break;
                case 4:
//                    TODO: GENERIC UPDATE OBJECT BY ID METHOD;
                    break;
                case 5:
//                    TODO: GENERIC DELETE OBJECT METHOD;
                    if (input.equals(User.class.getSimpleName())) {
                        deleteUser();
                    } else if (input.equals(Movies.class.getSimpleName())) {
                        deleteMovie();
                    } else if (input.equals(ProjectionRooms.class.getSimpleName())) {
                        deleteProjectionRoom();
                    } else if (input.equals(Booking.class.getSimpleName())) {
                        deleteBooking();
                    }

                    break;
                case 6:
                    System.out.println("Going back to the dashboard!");
                    break;
            }
        }
    }

    private void deleteBooking() {
        repository.delete(repository.findEntity(Booking.class.getSimpleName(),
                (keyboardHandler.readInt("Insert the id of the Booking you want to delete: "))));
    }

    private void deleteProjectionRoom() {
        repository.delete(repository.findEntity(ProjectionRooms.class.getSimpleName(),
                (keyboardHandler.readInt("Insert the id of the Projection Room you want to delete: "))));
    }

    private void deleteMovie() {
        repository.delete(repository.findEntity(Movies.class.getSimpleName(),
                (keyboardHandler.readInt("Insert the id of the Movie you want to delete: "))));
    }

    private void deleteUser() {
        repository.delete(repository.userCheckInDatabase(
                (keyboardHandler.readInt("Insert the id of the User you want to delete: "))));
    }


    private void createBooking() {
        Booking bookingToCreate = new Booking();
        ProjectionRooms projectionRooms = new ProjectionRooms();
        int userId = keyboardHandler.readInt("Insert user Id:");
        bookingToCreate.setUser(repository.userCheckInDatabase(userId));
        int roomId = keyboardHandler.readInt("Insert projection room Id:");
        bookingToCreate.setProjectionRooms((ProjectionRooms) repository.findEntity(ProjectionRooms.class.getSimpleName(), roomId));
        ;
        repository.save(bookingToCreate);
        System.out.println("======================================");
        System.out.println("BOOKING IN ROOM: " + bookingToCreate.getProjectionRooms().getName()
                + " FOR USER " + bookingToCreate.getUser().getName() + " WAS CREATED");
    }

    private void createProjectionRoom() {
        ProjectionRooms roomToCreate = new ProjectionRooms();
        roomToCreate.setName(keyboardHandler.readString("Name: "));
        roomToCreate.setSeats(keyboardHandler.readInt("Seats:"));
        repository.save(roomToCreate);
        System.out.println("======================================");
        System.out.println("PROJECTION ROOM " + roomToCreate.toString() + "WAS CREATED");


    }

    private void createMovie() {
        Movies movieToCreate = new Movies();
        movieToCreate.setName(keyboardHandler.readString("Name: "));
        repository.save(movieToCreate);
        System.out.println("MOVIE " + movieToCreate.toString() + "WAS CREATED");

    }

    private void createUser() {
        User userToCreate = new User();
        userToCreate.setName(keyboardHandler.readString("Name: "));
        userToCreate.setEmail(keyboardHandler.readString("Email: "));
        userToCreate.setPassword(keyboardHandler.readString("Password: "));

        if (!repository.userAlreadyInDatabase(userToCreate.getEmail())) {
            repository.save(userToCreate);
            System.out.println("======================================");
            System.out.println("USER " + userToCreate.toString() + "WAS CREATED");

        } else {
            System.out.println("======================================");
            System.out.println("AN ACCOUNT ASSOCIATED WITH THIS EMAIL ALREADY EXISTS!");
            System.out.println("TRY TO LOGIN INSTEAD");
        }
    }


}

