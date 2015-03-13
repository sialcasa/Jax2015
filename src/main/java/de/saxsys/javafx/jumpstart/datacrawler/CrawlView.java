package de.saxsys.javafx.jumpstart.datacrawler;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import org.w3c.dom.Document;

import de.saxsys.javafx.jumpstart.model.CrawlTargets;
import de.saxsys.javafx.jumpstart.model.Person;

public class CrawlView {

    @FXML
    private ChoiceBox<CrawlTargets> cb_source;

    @FXML
    private WebView wv_personinfo;

    @FXML
    private ProgressIndicator pi_loading;

    private final SimpleObjectProperty<Person> displayPerson = new SimpleObjectProperty<>();

    @FXML
    void initialize() {
        cb_source.itemsProperty().bind(CrawlTargets.valuesProperty());
        cb_source.getSelectionModel().select(0);

        displayPerson.addListener((ChangeListener<Person>) (observable, oldValue, newValue) -> {
            WebEngine webEngine = wv_personinfo.getEngine();
            webEngine.load(cb_source.getValue().getSearchUrl(newValue.getFirstname() + " " + newValue.getLastname()));
        });

        cb_source.valueProperty().addListener(
                (ChangeListener<CrawlTargets>) (observable, oldValue, newValue) -> {
                    WebEngine webEngine = wv_personinfo.getEngine();
                    webEngine.load(cb_source.getValue().getSearchUrl(
                            displayPerson.get().getFirstname() + " " + displayPerson.get().getLastname()));
                });

        wv_personinfo
                .getEngine()
                .documentProperty()
                .addListener(
                        (ChangeListener<Document>) (observable, oldValue, newValue) -> {
                            executejQuery(wv_personinfo.getEngine(), "");
                            wv_personinfo.getEngine().executeScript(Scripts.getStyleObject);
                            wv_personinfo.getEngine().executeScript(
                                    "$(document).click(function(event) {"
                                            + "$(event.target).closest('div').each(function() {"
                                            + "var style = $(this).getStyleObject();" + "java.target(style);" + "});"
                                            + "return false;" + "});");

                            JSObject jsobj = (JSObject) wv_personinfo.getEngine().executeScript("window");
                            jsobj.setMember("java", new Bridge());

                        });

        pi_loading.visibleProperty().bind(
                wv_personinfo.getEngine().getLoadWorker().stateProperty().isEqualTo(State.RUNNING));

    }

    private static Object executejQuery(final WebEngine engine, String script) {
        return engine.executeScript("(function(window, document, version, callback) { " + "var j, d;"
                + "var loaded = false;" + "if (!(j = window.jQuery) || version > j.fn.jquery || callback(j, loaded)) {"
                + " var script = document.createElement(\"script\");" + " script.type = \"text/javascript\";"
                + " script.src = \"http://code.jquery.com/jquery-1.7.2.min.js\";"
                + " script.onload = script.onreadystatechange = function() {"
                + " if (!loaded && (!(d = this.readyState) || d == \"loaded\" || d == \"complete\")) {"
                + " callback((j = window.jQuery).noConflict(1), loaded = true);" + " j(script).remove();" + " }"
                + " };" + " document.documentElement.childNodes[0].appendChild(script) " + "} "
                + "})(window, document, \"1.7.2\", function($, jquery_loaded) {" + script + "});");
    }

    public class Bridge {
        public void target(JSObject content) {
            System.out.println(content);
        }
    }

    public ObjectProperty<Person> displayPersonProperty() {
        return displayPerson;
    }
}
