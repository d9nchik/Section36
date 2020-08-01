package sample.exercise9;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.exercise3.CalendarPane;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class CalendarApp extends Application {
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("sample/exercise9/Calendar");
    private final CalendarPane calendarPane = new CalendarPane();
    private final Button btPrior = new Button("Prior");
    private final Button btNext = new Button("Next");
    private final ComboBox<String> cboLocales = new ComboBox<>();
    private final Locale[] availableLocales = Locale.getAvailableLocales();

    public CalendarApp() throws IOException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(btPrior, btNext);
        hBox.setAlignment(Pos.CENTER);
// Initialize cboLocales with all available locales
        setAvailableLocales();
        HBox hBoxLocale = new HBox(5);
        hBoxLocale.getChildren().addAll(
                new Label(resourceBundle.getString("Select_a_locale")), cboLocales);
        BorderPane pane = new BorderPane();
        pane.setCenter(calendarPane);
        pane.setTop(hBoxLocale);
        hBoxLocale.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);
        hBox.setAlignment(Pos.CENTER);
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle(resourceBundle.getString("title")); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        btPrior.setOnAction(e -> {
            int currentMonth = calendarPane.getMonth();
            if (currentMonth == 0) { // The previous month is 11 for Dec
                calendarPane.setYear(calendarPane.getYear() - 1);
                calendarPane.setMonth(11);
            } else {
                calendarPane.setMonth((currentMonth - 1) % 12);
            }
        });
        btNext.setOnAction(e -> {
            int currentMonth = calendarPane.getMonth();
            if (currentMonth == 11) // The next month is 0 for Jan
                calendarPane.setYear(calendarPane.getYear() + 1);
            calendarPane.setMonth((currentMonth + 1) % 12);
        });
        cboLocales.setOnAction(e ->
                calendarPane.setLocale(availableLocales[cboLocales.
                        getSelectionModel().getSelectedIndex()]));
    }

    private void setAvailableLocales() {
        for (Locale availableLocale : availableLocales)
            cboLocales.getItems().add(availableLocale
                    .getDisplayName() + " " + availableLocale.toString());
        cboLocales.getSelectionModel().selectFirst();
    }

}
