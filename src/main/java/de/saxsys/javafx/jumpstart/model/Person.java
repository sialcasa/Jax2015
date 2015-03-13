package de.saxsys.javafx.jumpstart.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class Person {

    StringProperty firstname = new SimpleStringProperty();
    StringProperty lastname = new SimpleStringProperty();

    ListProperty<String> informations = new SimpleListProperty<>();

    ListProperty<String> resources = new SimpleListProperty<>(FXCollections.observableArrayList());

    public Person(String firstname, String lastname) {
        this.firstname.set(firstname);
        this.lastname.set(lastname);
    }

    public StringProperty firstnameProperty() {
        return this.firstname;
    }

    public java.lang.String getFirstname() {
        return this.firstnameProperty().get();
    }

    public void setFirstname(final java.lang.String firstname) {
        this.firstnameProperty().set(firstname);
    }

    public StringProperty lastnameProperty() {
        return this.lastname;
    }

    public java.lang.String getLastname() {
        return this.lastnameProperty().get();
    }

    public void setLastname(final java.lang.String lastname) {
        this.lastnameProperty().set(lastname);
    }

    public ListProperty<String> resourcesProperty() {
        return this.resources;
    }

    public javafx.collections.ObservableList<java.lang.String> getResources() {
        return this.resourcesProperty().get();
    }

    public void setResources(final javafx.collections.ObservableList<java.lang.String> resources) {
        this.resourcesProperty().set(resources);
    }

    public ListProperty<String> informationsProperty() {
        return this.informations;
    }

}
