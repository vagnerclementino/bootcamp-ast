package me.clementino.solid.interfacesegregation.crud;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCRUDV2<T> implements IRead<T>, ISave<T>, IDelete<T> {

    private List<T> storage;

    public InMemoryCRUDV2() {
        this.storage = new ArrayList<>();
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
    public void save(T entity) {
        storage.removeIf(e -> e.equals(entity));
        storage.add(entity);
    }

    @Override
    public void delete(T entity) {
        storage.removeIf(e -> e.equals(entity));
    }

    public int getSize() {
        return storage.size();
    }
}
