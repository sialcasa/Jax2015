package de.saxsys.javafx.jumpstart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Starter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent load = FXMLLoader.load(getClass().getResource("JumpstartView.fxml"));

        // Undecorator undecorator = new Undecorator(primaryStage, (Region) load);
        // primaryStage.initStyle(StageStyle.TRANSPARENT);
        // undecorator.getStylesheets().add("skin/undecorator.css");
        // Scene scene = new Scene(undecorator, 1200, 700);
        Scene scene = new Scene(load, 1200, 700);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
