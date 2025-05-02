import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Slide3Controller implements Initializable {

    @FXML
    Label coffeeLabel;
    @FXML
    Label boomLabel;

    private void launchInifiniteAnimation() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), coffeeLabel);
        rotateTransition.setFromAngle(-45);
        rotateTransition.setToAngle(45);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), boomLabel);
        scaleTransition.setFromX(0.8);
        scaleTransition.setFromY(0.8);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.setAutoReverse(true);

        rotateTransition.play();
        scaleTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        launchInifiniteAnimation();
    }
}
