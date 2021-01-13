package me.clementino.solid.interfacesegregation.crud;

import java.util.List;

public interface IRead <T>{
    T readOne(T entity);
    List<T> readAll();
}
