package sample.exercise1;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EncodingFormatController {
    @FXML
    private TextField startSymbol;

    @FXML
    private TextArea textArea;

    public void show() {
        int symbol = Integer.parseInt(startSymbol.getText(), 16);
        textArea.setText((char) symbol + "");
    }
}
