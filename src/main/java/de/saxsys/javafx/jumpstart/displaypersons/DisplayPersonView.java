package de.saxsys.javafx.jumpstart.displaypersons;

import java.util.function.Predicate;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.util.Duration;
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
        // TODO Beispiel memory leak
        persons.addListener((ListChangeListener<Person>) c -> {

            while (c.next()) {
                for (Person additem : c.getAddedSubList()) {
                    Predicate<Person> check = createPredicate();
                    boolean test = check.test(additem);
                    if (!test) {
                        DropShadow dropShadow = new DropShadow(0, Color.ORANGE);
                        tf_searchperson.setEffect(dropShadow);

                        KeyValue keyValue = new KeyValue(dropShadow.radiusProperty(), 20);
                        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
                        Timeline timeline = new Timeline(keyFrame);
                        timeline.setAutoReverse(true);
                        timeline.setCycleCount(2);
                        timeline.play();
                        timeline.setOnFinished(arg0 -> lv_persons.setEffect(null));
                    }
                }
            }
        });

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
