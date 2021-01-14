package me.clementino.solid.interfacesegregation.crud;

import java.util.List;

public class ReadCaching<T> implements IRead<T>{

    private final IRead<T> decoratedRead;

    public ReadCaching(IRead<T> decoratedRead) {
        this.decoratedRead = decoratedRead;
    }

    @Override
    public T readOne(T entity) {
        // TODO: Here we must implement a readOne method with caching
        return decoratedRead.readOne(entity);
    }

    @Override
    public List<T> readAll() {
        // TODO: Here we must implement a readAll method with caching
        return decoratedRead.readAll();
    }
}
