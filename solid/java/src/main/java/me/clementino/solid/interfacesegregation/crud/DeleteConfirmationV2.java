package me.clementino.solid.interfacesegregation.crud;

import java.util.Scanner;

public class DeleteConfirmationV2<T> implements IDelete<T> {

    private final IDelete<T> decoratedDelete;

    public DeleteConfirmationV2(IDelete<T> decoratedDelete) {
        this.decoratedDelete = decoratedDelete;
    }

    @Override
    public void delete(T entity) {
        var scanner = new Scanner(System.in);
        System.out.print("Are you sure you want to delete the entity? [y/N]");
        var userConfirmation = scanner.next();

        if ("Y".equalsIgnoreCase(userConfirmation)){
            this.decoratedDelete.delete(entity);
        }
    }
}
