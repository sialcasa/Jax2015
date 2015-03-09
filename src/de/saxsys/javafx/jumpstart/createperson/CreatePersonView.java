package de.saxsys.javafx.jumpstart.createperson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import de.saxsys.javafx.jumpstart.model.Repository;

public class CreatePersonView {

    @FXML
    private TextField tf_firstname;

    @FXML
    private TextField tf_surname;

    @FXML
    private Button btn_addPerson;

    @FXML
    void addButtonPressed(ActionEvent event) {
        Repository.persons.add(tf_firstname.getText() + " " + tf_surname.getText());
    }

    protected void initialize() {
        btn_addPerson.disableProperty().bind(
                tf_firstname.textProperty().isNotEmpty().and(tf_surname.textProperty().isNotEmpty()));
    }
}
