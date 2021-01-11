package me.clementino.solid.interfacesegregation;

import java.util.List;

public interface ICreateReadUpdateDelete<T> {

    void create(T entity);

    T readOne(Long id);

    List<T> readAll();

    void update(T entity);

    void delete(T entity);
}
