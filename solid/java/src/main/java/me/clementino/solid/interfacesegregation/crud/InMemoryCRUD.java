package me.clementino.solid.interfacesegregation.crud;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCRUD<T> implements ICreateReadUpdateDelete<T> {

    private List<T> storage;

    public InMemoryCRUD() {
        this.storage = new ArrayList<>();
    }

    @Override
    public void create(T entity) {
        storage.add(entity);
    }

    @Override
    public T readOne(T entity) {
        var optionalT = storage
            .stream()
            .filter(e -> e.equals(entity))
            .findAny();

        if (optionalT.isPresent()) {
            return optionalT.get();
        }
        return null;
    }

    @Override
    public List<T> readAll() {
        return storage;
    }

    @Override
    public void update(T entity) {
        if (storage.removeIf(e -> e.equals(entity))) {
            storage.add(entity);
        }
    }

    @Override
    public void delete(T entity) {
        storage.removeIf(e -> e.equals(entity));
    }

    public int getSize() {
        return storage.size();
    }
}
