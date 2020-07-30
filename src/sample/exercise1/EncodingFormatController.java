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
        textArea.clear();
        int symbol = Integer.parseInt(startSymbol.getText(), 16);
        for (int i = 0; i < 20; i++) {
            StringBuilder line = new StringBuilder(Integer.toHexString(symbol));
            for (int j = 0; j < 16; j++) {
                line.append(" ").append((char) symbol++);
            }
            textArea.appendText(line.append("\n").toString());
        }
    }
}
