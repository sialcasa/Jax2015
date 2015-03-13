package de.saxsys.javafx.jumpstart;

import javafx.fxml.FXML;
import javafx.scene.Node;
import de.saxsys.javafx.jumpstart.crawlresults.CrawlResultsView;
import de.saxsys.javafx.jumpstart.createperson.CreatePersonView;
import de.saxsys.javafx.jumpstart.datacrawler.CrawlView;
import de.saxsys.javafx.jumpstart.displaypersons.DisplayPersonView;

public class JumpstartView {

    @FXML
    private Node import_createPerson;
    @FXML
    private Node import_crawlResults;
    @FXML
    private Node import_crawler;
    @FXML
    private Node import_displayPersons;

    @FXML
    private CreatePersonView import_createPersonController;
    @FXML
    private CrawlResultsView import_crawlResultsController;
    @FXML
    private CrawlView import_crawlerController;
    @FXML
    private DisplayPersonView import_displayPersonsController;

    @FXML
    public void initialize() {
        import_crawlerController.displayPersonProperty().bind(import_displayPersonsController.selectedPersonProperty());
    }
}
