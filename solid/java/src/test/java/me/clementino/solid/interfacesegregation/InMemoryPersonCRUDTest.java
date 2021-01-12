package me.clementino.solid.interfacesegregation;

import me.clementino.solid.interfacesegregation.crud.InMemoryCRUD;
import me.clementino.solid.interfacesegregation.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class InMemoryPersonCRUDTest {

    private InMemoryCRUD<Person> subject;

    @BeforeEach
    void setUp() {
        subject = new InMemoryCRUD<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldCreateAPerson() {
        //Given
        var p1 = new Person("Maria", 10);
        var p2 = new Person("José", 10);

        //When
        subject.create(p1);
        subject.create(p2);

        //Then
        assertThat(subject.getSize(), is(equalTo(2)));
    }

    @Test
    void shouldReadOnePerson() {

        //Given
        var p1 = new Person("Maria", 10);

        //When
        subject.create(p1);
        var foundPerson = subject.readOne(p1);

        //Then
        assertThat(foundPerson, is(equalTo(p1)));
    }

    @Test
    void shouldReadAllPersonsWithSuccess() {

        //Given
        var p1 = new Person("Maria", 10);
        var p2 = new Person("José", 20);
        var p3 = new Person("João", 30);
        var personToInsert = Arrays.asList(p1, p2, p3);

        //When
        personToInsert.stream().forEach(p -> subject.create(p));

        //Then
        var allReadPerson = subject.readAll();
        assertThat(allReadPerson, is(equalTo(personToInsert)));
    }

    @Test
    void shouldUpdateAPersonWithSuccess() {
        //Given
        var oldName = "Maria";
        var newAge = 20;
        var oldPerson = new Person(oldName, 10);

        //When
        subject.create(oldPerson);
        var newPerson = new Person(oldName, newAge);
        subject.update(newPerson);

        //Then
        var updatedPerson = subject.readOne(newPerson);
        assertThat(updatedPerson.getName(), is(oldName));
        assertThat(updatedPerson.getAge(), is(newAge));
    }

    @Test
    void shouldDeleteAPersonWithSuccess() {
        //Given
        var p1 = new Person("Maria", 10);
        var p2 = new Person("José", 10);

        //When
        subject.create(p1);
        subject.create(p2);

        //Then
        subject.delete(p1);
        assertThat(subject.readAll(), not(hasItem(p1)));
    }
}
