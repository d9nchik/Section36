package sample.exercise3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DateApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(new CalendarPane(), new WorldClock());
        pane.setSpacing(10);
        pane.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(pane, 720, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 3");
        primaryStage.show();
    }
}
