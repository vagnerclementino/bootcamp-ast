package me.clementino.solid.interfacesegregation.crud;

import me.clementino.solid.interfacesegregation.crud.ICreateReadUpdateDelete;

import java.util.List;
import java.util.Scanner;

public class DeleteConfirmationCRUD<T> implements ICreateReadUpdateDelete<T> {

    private final ICreateReadUpdateDelete decoratedCRUD;

    public DeleteConfirmationCRUD(ICreateReadUpdateDelete<T> decoratedCRUD) {
        this.decoratedCRUD = decoratedCRUD;
    }

    @Override
    public void create(T entity) {
        this.decoratedCRUD.create(entity);
    }

    @Override
    public T readOne(T entity) {
        return (T) this.decoratedCRUD.readOne(entity);
    }

    @Override
    public List<T> readAll() {
        return this.decoratedCRUD.readAll();
    }

    @Override
    public void update(T entity) {
        this.decoratedCRUD.update(entity);
    }

    @Override
    public void delete(T entity) {
        var scanner = new Scanner(System.in);
        System.out.print("Are you sure you want to delete the entity? [y/N]");
        var userConfirmation = scanner.next();

        if ("Y".equalsIgnoreCase(userConfirmation)){
            this.decoratedCRUD.delete(entity);
        }
    }
}
