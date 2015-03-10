package de.saxsys.javafx.jumpstart.crawlresults;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CrawlResultsView {

    @FXML
    private VBox vb_webviews;

    @FXML
    void initialize() {

        try {
            for (int i = 0; i < 10; i++) {
                Node load = FXMLLoader.load(CrawlResultsView.class.getResource("ResultView.fxml"));
                VBox.setVgrow(load, Priority.ALWAYS);
                vb_webviews.getChildren().add(load);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
