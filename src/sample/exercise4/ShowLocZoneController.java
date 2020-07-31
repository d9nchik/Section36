package sample.exercise4;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

public class ShowLocZoneController {
    @FXML
    private TextArea textArea;

    private String locales, zones;


    @FXML
    public void initialize() {
        locales = Stream.of(Locale.getAvailableLocales()).map(Locale::getDisplayName).filter(e -> !e.isEmpty()).collect(
                StringBuilder::new, (c, e) -> c.append(e).append("\n"), StringBuilder::append).toString();
        zones = Stream.of(TimeZone.getAvailableIDs()).collect(
                StringBuilder::new, (c, e) -> c.append(e).append("\n"), StringBuilder::append).toString();
        showLocales();
    }

    @FXML
    public void showLocales() {
        textArea.setText(locales);
    }

    @FXML
    public void showZones() {
        textArea.setText(zones);
    }
}
