package de.saxsys.javafx.jumpstart.effects;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import de.saxsys.javafx.jumpstart.properties.Persons;

public class EffectsViewController {

    @FXML
    private TextField tf_firstname;

    @FXML
    private TextField tf_lastname;

    @FXML
    private Label lbl_info;

    @FXML
    void addButtonPressed(ActionEvent event) {
        Persons.persons.add(tf_firstname + " " + tf_lastname);
    }

    public void initialize() {
        lbl_info.textProperty().bind(
                Bindings.concat("Soll ", tf_firstname.textProperty(), " ", tf_lastname.textProperty(),
                        " angelegt werden?"));

        lbl_info.visibleProperty().bind(
                tf_firstname.textProperty().isNotEmpty().and(tf_lastname.textProperty().isNotEmpty()));
    }
}
