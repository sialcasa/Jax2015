package de.saxsys.javafx.jumpstart.properties;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PropertiesView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tf_summandTwo;

    @FXML
    private TextField tf_summandOne;

    @FXML
    private Label lbl_solution;

    @FXML
    void initialize() {
    }
}
