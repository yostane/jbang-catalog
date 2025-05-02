import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Slide1Controller implements Initializable {
    @FXML
    private Label titleLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleLabel.setText(String.format("Hello JavaFX %s!", System.getProperty("javafx.version")));
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Button clicked!");
    }

}
