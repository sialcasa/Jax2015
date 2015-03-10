package de.saxsys.javafx.jumpstart.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class PersonService {

    private static PersonService INSTANCE = new PersonService();

    private final SimpleListProperty<Person> persons = new SimpleListProperty<>(FXCollections.observableArrayList(
            new Person("Alexander", "Casall"), new Person("Stefanie", "Albrecht")));

    public void createPerson(String firstName, String lastName) {
        persons.add(new Person(firstName, lastName));
    }

    public final SimpleListProperty<Person> personsProperty() {
        return this.persons;
    }

    public static PersonService getInstance() {
        return INSTANCE;
    }

}
