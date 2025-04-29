import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Slide1Controller implements Initializable {

    @FXML
    ImageView jbangLogo;

    public void handleClick() throws IOException {
        Logger.getGlobal().info("Button clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setAutoReverse(true);
        rotateTransition.setByAngle(180);
        rotateTransition.setDuration();
        rotateTransition.play();

        FadeTransition transition = new FadeTransition(Duration.seconds(5), jbangLogo);
        transition.setFromValue(1.0);
        transition.setToValue(0);
        transition.setInterpolator(Interpolator.LINEAR);

        transition.play();
    }
}
