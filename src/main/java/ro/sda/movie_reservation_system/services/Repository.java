package ro.sda.movie_reservation_system.services;

import org.hibernate.Session;
import ro.sda.movie_reservation_system.configuration.HibernateUtil;
import ro.sda.movie_reservation_system.dao.Dao;
import ro.sda.movie_reservation_system.entities.GenericEntity;
import ro.sda.movie_reservation_system.entities.User;


import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class Repository implements Dao<GenericEntity> {
    Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Optional<GenericEntity> get(int id) {
        return Optional.ofNullable(session.find(User.class, id));
    }

    @Override
    public List<GenericEntity> getAll(String className) {
        Query query = session.createQuery("SELECT e FROM " + className+ " e");
        return query.getResultList();
    }


//TODO --  CREATE -- DONE
    public void save(GenericEntity entity) {
        try {
            executeInsideTransaction(entityManager -> entityManager.persist(entity));
            System.out.println("======================================");
            System.out.println("ENTRY SUCCESSFULLY SAVED");
        }catch (Exception e) {
            System.out.println("======================================");
            System.out.println("CANNOT ADD --> THIS ENTRY ALREADY EXISTS IN DATABASE");
        }

    }

    //TODO --  DELETE --
    public void delete(GenericEntity entity) {
        try {
            executeInsideTransaction(session -> session.remove(entity));
            System.out.println("======================================");
            System.out.println( "ENTRY SUCCESSFULLY DELETED");

        }catch (Exception e){
            System.out.println("======================================");
            System.out.println("CANNOT DELETE --> THIS ENTRY DOES WAS NOT FOUND IN THE DATABASE");
        }

    }

    //TODO --  FIND --
    public GenericEntity findEntity(String className, int id){
        String sqlQuery = "SELECT e FROM " + className + " e " +
                "WHERE id ='" + id + "'";
        org.hibernate.query.Query query = session.createQuery(sqlQuery);
        List<GenericEntity> foundEntity = query.getResultList();
        if (foundEntity.isEmpty()) {
            System.out.println("USER NOT IN DATABASE!");
            return null;
        }
        return foundEntity.get(0);
    }
    //TODO --  UPDATE --
    public void update(User user, User u) {
        user.setName(Objects.requireNonNull(u.getName(), "Name cannot be null"));
        user.setEmail(Objects.requireNonNull(u.getEmail(), "Email cannot be null"));
        executeInsideTransaction(session -> session.merge(user));
    }

    public boolean checkExistingUser(String email, String password) {
       try {
           // in query trebuie folosit numele clasei(tabele) din java code (case sensitive);
           String sqlQuery = "SELECT e FROM User e " +
                   "WHERE email ='" + email + "' AND password = '" + password + "'";
           org.hibernate.query.Query query = session.createQuery(sqlQuery);
           List <User> foundUser = query.getResultList();

           if (foundUser != null) {
               System.out.println("Welcome, " + foundUser.get(0).getName());
               return true;
           }
           return false;
       } catch (Exception e){
           System.out.println("YOU ARE NOT CONNECTED TO THE DATABASE!");
           return false;
       }
    }

    public boolean userAlreadyInDatabase(String email) {
            // in query trebuie folosit numele clasei(tabele) din java code (case sensitive);
            String sqlQuery = "SELECT e FROM User e " +
                    "WHERE email ='" + email + "'";
            org.hibernate.query.Query query = session.createQuery(sqlQuery);
            List <User> foundUser = query.getResultList();
            if (foundUser.isEmpty()) {
                return false;
            }
            return true;
        }

        public User userCheckInDatabase ( int id){
        // in query trebuie folosit numele clasei(tabele) din java code (case sensitive);
        String sqlQuery = "SELECT e FROM User e " +
                "WHERE id ='" + id + "'";
            org.hibernate.query.Query query = session.createQuery(sqlQuery);
            List<User> foundUser = query.getResultList();
            if (foundUser.isEmpty()) {
                System.out.println("USER NOT IN DATABASE!");
                return null;
            }
            return foundUser.get(0);
    }


    private void executeInsideTransaction(Consumer<Session> action) {
        EntityTransaction tx = session.getTransaction();
        try {
            tx.begin();
            action.accept(session);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

    @Override
    public void update(GenericEntity entity, GenericEntity u) {

    }
}
