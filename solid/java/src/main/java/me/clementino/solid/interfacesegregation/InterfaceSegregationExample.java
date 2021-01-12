package me.clementino.solid.interfacesegregation;

import me.clementino.solid.interfacesegregation.controller.PersonController;
import me.clementino.solid.interfacesegregation.crud.DeleteConfirmationCRUD;
import me.clementino.solid.interfacesegregation.crud.InMemoryCRUD;
import me.clementino.solid.interfacesegregation.entity.Person;

public class InterfaceSegregationExample {
    public static void main(String[] args) {

        //Creates the person entity
        var p1 = new Person("Maria", 10);
        var p2 = new Person ("Jose", 20);

        //Creates an in memory CRUD
        var inMemoryCRUD = new InMemoryCRUD<Person>();
        //Creates a default controller with a in memory CRUD
        var personControllerDefault = new PersonController(inMemoryCRUD);
        System.out.println("# START CONTROLLER DEFAULT #");

        System.out.println("----------------------------------------------------");

        personControllerDefault.savePerson(p1);
        personControllerDefault.savePerson(p2);
        personControllerDefault.deletePerson(p2);
        System.out.println("Deleted with success, but no confirmation!");
        System.out.println("# END CONTROLLER DEFAULT #");

        System.out.println("----------------------------------------------------");

        var deleteWithConfirmationCRUD = new DeleteConfirmationCRUD<>(inMemoryCRUD);
        var personControllerWithConfirmation = new PersonController(deleteWithConfirmationCRUD);
        System.out.println("# START CONTROLLER WITH CONFIRMATION #");

        personControllerWithConfirmation.savePerson(p1);
        personControllerWithConfirmation.savePerson(p2);
        personControllerWithConfirmation.deletePerson(p2);

        System.out.println("Deleted with success, with confirmation!");
        System.out.println("# END CONTROLLER WITH CONFIRMATION #");
        System.out.println("----------------------------------------------------");
    }
}
