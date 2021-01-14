package me.clementino.solid.interfacesegregation.crud;

import java.util.List;

public interface ICreateReadUpdateDelete<T> {

    void create(T entity);

    T readOne(T entity);

    List<T> readAll();

    void update(T entity);

    void delete(T entity);
}
