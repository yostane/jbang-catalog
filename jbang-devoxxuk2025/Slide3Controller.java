import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Slide3Controller implements Initializable {

    @FXML
    Label coffeeLabel, boomLabel, fingerLabel, penLabel;

    private void launchAnimations() {
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

        penLabel.setTranslateY(-10);
        TranslateTransition penTransition = new TranslateTransition(Duration.millis(500), penLabel);
        penTransition.setFromX(-50);
        penTransition.setToX(-20);
        penTransition.setCycleCount(Timeline.INDEFINITE);
        penTransition.setAutoReverse(true);

        TranslateTransition fingerTransition = new TranslateTransition(Duration.millis(500), fingerLabel);
        fingerTransition.setToY(10);
        fingerTransition.setCycleCount(Timeline.INDEFINITE);
        fingerTransition.setAutoReverse(true);

        penTransition.play();
        fingerTransition.play();
        rotateTransition.play();
        scaleTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        launchAnimations();
    }
}
