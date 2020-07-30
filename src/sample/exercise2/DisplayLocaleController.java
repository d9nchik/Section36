package sample.exercise2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

public class DisplayLocaleController {
    private final Date DATE = new Date();
    private final Locale[] LOCALE = Locale.getAvailableLocales();
    @FXML
    private TextField date, time;
    @FXML
    private ComboBox<String> locale;
    @FXML
    private ComboBox<String> timeZone;
    @FXML
    private ComboBox<String> dataStyle, timeStyle;

    private static int getStyle(String word) {
        switch (word) {
            case "SHORT":
                return DateFormat.SHORT;
            case "MEDIUM":
                return DateFormat.MEDIUM;
            case "LONG":
                return DateFormat.LONG;
            default:
                return DateFormat.FULL;
        }
    }

    @FXML
    public void initialize() {
        Stream.of(LOCALE).map(Locale::getDisplayName).forEach(
                e -> locale.getItems().add(e));
        locale.getSelectionModel().selectFirst();
        timeZone.getItems().addAll(TimeZone.getAvailableIDs());
        timeZone.getSelectionModel().selectFirst();
        final String[] STYLES = {"SHORT", "MEDIUM", "LONG", "FULL"};
        dataStyle.getItems().addAll(STYLES);
        dataStyle.getSelectionModel().selectFirst();
        timeStyle.getItems().addAll(STYLES);
        timeStyle.getSelectionModel().selectFirst();

        update();
    }

    public void update() {
        Locale loc = LOCALE[locale.getItems().indexOf(locale.getValue())];
        TimeZone tZone = TimeZone.getTimeZone(timeZone.getValue());
        DateFormat dateFormat = DateFormat.getDateInstance(getStyle(dataStyle.getValue()), loc);
        dateFormat.setTimeZone(tZone);
        date.setText(dateFormat.format(DATE));

        DateFormat timeFormat = DateFormat.getTimeInstance(getStyle(timeStyle.getValue()), loc);
        timeFormat.setTimeZone(tZone);
        time.setText(timeFormat.format(DATE));
    }
}
