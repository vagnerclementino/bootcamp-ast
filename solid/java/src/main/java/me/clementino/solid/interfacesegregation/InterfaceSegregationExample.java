package me.clementino.solid.interfacesegregation;

import me.clementino.solid.interfacesegregation.controller.PersonController;
import me.clementino.solid.interfacesegregation.controller.PersonControllerV2;
import me.clementino.solid.interfacesegregation.crud.*;
import me.clementino.solid.interfacesegregation.entity.Person;

public class InterfaceSegregationExample {
    public static void main(String[] args) {

        //Creates the person entity
        var p1 = new Person("Maria", 10);
        var p2 = new Person ("Jose", 20);

        // Creates an in memory CRUD
        var personInMemoryCRUD = new InMemoryCRUD<Person>();

        // Creates a default controller with a in memory CRUD
        var personControllerDefault = new PersonController(personInMemoryCRUD);
        System.out.println("----------------------------------------------------");

        personControllerDefault.savePerson(p1);
        personControllerDefault.savePerson(p2);

        var allPersonsDefaultController = personControllerDefault.findAll();
        System.out.println("Default Controller - Find all persons: ");
        allPersonsDefaultController.stream().forEach(System.out::println);

        var optionalPerson = personControllerDefault.findPerson(p1);
        optionalPerson.ifPresent( person -> System.out.println("Default Controller - Find the " + person));

        optionalPerson = personControllerDefault.findPerson(p1);
        optionalPerson.ifPresent( person -> System.out.println("Default Controller - Find the " + person));

        personControllerDefault.deletePerson(p2);
        System.out.println("Default Controller - Deleted with success, but no confirmation!");

        allPersonsDefaultController = personControllerDefault.findAll();
        System.out.println("Default Controller - Find all persons: ");
        allPersonsDefaultController.stream().forEach(System.out::println);

        System.out.println("----------------------------------------------------");


        // This version from PersonController we've used a decorated version from deletion
        // feature where there is a kind of user's confirmation
        var personDeleteConfirmation = new DeleteConfirmation<>(new InMemoryCRUD<Person>());
        var personControllerWithConfirmation = new PersonController(personDeleteConfirmation);

        personControllerWithConfirmation.savePerson(p1);
        personControllerWithConfirmation.savePerson(p2);

        var allPersonsControllerWithConfirmation = personControllerWithConfirmation.findAll();
        System.out.println("Controller With Confirmation - Find all persons: ");
        allPersonsControllerWithConfirmation.stream().forEach(System.out::println);

        optionalPerson = personControllerWithConfirmation.findPerson(p1);
        optionalPerson.ifPresent( person -> System.out.println("Controller With Confirmation - Find the " + person));

        optionalPerson = personControllerWithConfirmation.findPerson(p2);
        optionalPerson.ifPresent( person -> System.out.println("Controller With Confirmation - Find the " + person));

        personControllerWithConfirmation.deletePerson(p2);
        System.out.println("Controller With Confirmation - Deleted with success, with confirmation!");

        allPersonsControllerWithConfirmation = personControllerWithConfirmation.findAll();
        System.out.println("Controller With Confirmation - Find all persons:");
        allPersonsControllerWithConfirmation.stream().forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------");


        // Here we will use the second version from person's controller (PersonControllerV2). This
        // version uses a segregated interface
        var personInMemoryCRUDV2 = new InMemoryCRUDV2<Person>();
        var personDeleteConfirmationV2 = new DeleteConfirmationV2<>(personInMemoryCRUDV2);
        var personReadCaching = new ReadCaching<>(personInMemoryCRUDV2);
        var personSaveAuditing = new SaveAuditing<>(personInMemoryCRUDV2);
        var personControllerV2 = new PersonControllerV2(personDeleteConfirmationV2,
                                                        personReadCaching,
                                                        personSaveAuditing
                                                        );
        personControllerV2.savePerson(p1);
        personControllerV2.savePerson(p2);

        optionalPerson= personControllerV2.findPerson(p1);
        optionalPerson.ifPresent( person -> System.out.println("Controller V2 - Find the " + person));

        optionalPerson= personControllerV2.findPerson(p2);
        optionalPerson.ifPresent( person -> System.out.println("Controller V2 - Find the " + person));

        var allPersonsV2 = personControllerV2.findAll();
        System.out.println("Find all persons: ");
        allPersonsV2.stream().forEach(System.out::println);

        personControllerV2.deletePerson(p2);
        System.out.println("Controller V2 - Deleted with success, with confirmation!");
        System.out.println("--------------------------------------------------------");
    }
}
