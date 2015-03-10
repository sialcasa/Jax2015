package de.saxsys.javafx.jumpstart.displaypersons;

import java.util.function.Predicate;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import de.saxsys.javafx.jumpstart.model.Person;
import de.saxsys.javafx.jumpstart.model.PersonService;

public class DisplayPersonView {

    @FXML
    private TextField tf_searchperson;

    @FXML
    private ListView<Person> lv_persons;

    private final ReadOnlyObjectWrapper<Person> selectedPerson = new ReadOnlyObjectWrapper<>();

    @FXML
    void initialize() {
        initCellFactory();
        initBindings();
    }

    private void initCellFactory() {
        lv_persons.setCellFactory(p -> {
            ListCell<Person> cell = new ListCell<Person>() {
                @Override
                protected void updateItem(Person t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null) {
                        setText(t.getFirstname() + " " + t.getLastname());
                    } else {
                        setText("");
                    }
                }
            };
            return cell;
        });
    }

    private void initBindings() {
        SimpleListProperty<Person> persons = PersonService.getInstance().personsProperty();
        FilteredList<Person> filteredPersons = persons.filtered(createPredicate());
        tf_searchperson.textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            filteredPersons.setPredicate(createPredicate());
        });

        lv_persons.itemsProperty().bind(new SimpleListProperty<>(filteredPersons));
        selectedPerson.bind(lv_persons.getSelectionModel().selectedItemProperty());
    }

    private Predicate<Person> createPredicate() {
        return t -> (t.firstnameProperty().get().toLowerCase()
                .startsWith(tf_searchperson.textProperty().get().toLowerCase()) || t.lastnameProperty().get()
                .toLowerCase().startsWith(tf_searchperson.textProperty().get().toLowerCase()));
    }

    public ReadOnlyObjectProperty<Person> selectedPersonProperty() {
        return selectedPerson.getReadOnlyProperty();
    }
}
