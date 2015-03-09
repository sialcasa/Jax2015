package de.saxsys.javafx.jumpstart.displaypersons;

import java.util.function.Predicate;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import de.saxsys.javafx.jumpstart.model.Repository;

public class DisplayPersonView {

    @FXML
    private TextField tf_searchperson;

    @FXML
    private ListView<String> lv_persons;

    @FXML
    void initialize() {
        SimpleListProperty<String> persons = Repository.persons;
        FilteredList<String> filteredPersons = persons.filtered(createPredicate());

        tf_searchperson.textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            filteredPersons.setPredicate(createPredicate());
        });

        lv_persons.itemsProperty().bind(new SimpleListProperty<>(filteredPersons));

    }

    private Predicate<String> createPredicate() {
        return t -> t.toLowerCase().startsWith(tf_searchperson.textProperty().get().toLowerCase());
    }
}
