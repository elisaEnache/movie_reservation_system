package ro.sda.movie_reservation_system.dao;


import ro.sda.movie_reservation_system.entities.GenericEntity;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends GenericEntity> {

    Optional<T> get(int id);

    List<T> getAll(String ClassName);

    void save(T t);

    void update(T t, T u);

    void delete(T t);
}
