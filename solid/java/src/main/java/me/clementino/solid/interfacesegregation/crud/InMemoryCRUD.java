package me.clementino.solid.interfacesegregation.crud;

import me.clementino.solid.interfacesegregation.crud.ICreateReadUpdateDelete;

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
        var optionalT = this.storage
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
        return this.storage;
    }

    @Override
    public void update(T entity) {
        if (this.storage.removeIf(e -> e.equals(entity))) {
            this.storage.add(entity);
        }
    }

    @Override
    public void delete(T entity) {
        this.storage.removeIf(e -> e.equals(entity));
    }

    public int getSize() {
        return this.storage.size();
    }
}
