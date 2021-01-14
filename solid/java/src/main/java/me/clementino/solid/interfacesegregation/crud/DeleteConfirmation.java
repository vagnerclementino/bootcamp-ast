package me.clementino.solid.interfacesegregation.crud;

import me.clementino.solid.interfacesegregation.crud.ICreateReadUpdateDelete;

import java.util.List;
import java.util.Scanner;

public class DeleteConfirmation<T> implements ICreateReadUpdateDelete<T> {

    private final ICreateReadUpdateDelete<T> decoratedCRUD;

    public DeleteConfirmation(ICreateReadUpdateDelete<T> decoratedCRUD) {
        this.decoratedCRUD = decoratedCRUD;
    }

    @Override
    public void create(T entity) {
        decoratedCRUD.create(entity);
    }

    @Override
    public T readOne(T entity) {
        return (T) decoratedCRUD.readOne(entity);
    }

    @Override
    public List<T> readAll() {
        return decoratedCRUD.readAll();
    }

    @Override
    public void update(T entity) {
        decoratedCRUD.update(entity);
    }

    @Override
    public void delete(T entity) {
        var scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete the entity? [y/N]");
        var userConfirmation = scanner.next();

        if ("Y".equalsIgnoreCase(userConfirmation)) {
            this.decoratedCRUD.delete(entity);
        }
    }
}
