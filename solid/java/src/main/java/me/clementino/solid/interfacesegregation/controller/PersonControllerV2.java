package me.clementino.solid.interfacesegregation.controller;

import me.clementino.solid.interfacesegregation.crud.IDelete;
import me.clementino.solid.interfacesegregation.crud.IRead;
import me.clementino.solid.interfacesegregation.crud.ISave;
import me.clementino.solid.interfacesegregation.entity.Person;

import java.util.List;
import java.util.Optional;

public class PersonControllerV2 {

    private final IDelete<Person> deleter;
    private final IRead<Person> reader;
    private final ISave<Person> saver;

    public PersonControllerV2(IDelete<Person> deleter, IRead<Person> reader, ISave<Person> saver) {
        this.deleter = deleter;
        this.reader = reader;
        this.saver = saver;
    }


    public Optional<Person> findPerson(Person person) {
        return Optional.ofNullable(reader.readOne(person));
    }

    public List<Person> findAll() {
        return reader.readAll();
    }

    public void savePerson(Person person) {
        saver.save(person);
    }

    public void updatePerson(Person person) {
        saver.save(person);
    }

    public void deletePerson(Person person) {
        deleter.delete(person);
    }
}
