package de.saxsys.javafx.jumpstart.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Repository {
    public static SimpleListProperty persons = new SimpleListProperty<String>(FXCollections.observableArrayList(
            "Alexander Casall", "Stefanie Albrecht"));
}
