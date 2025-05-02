import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Slide1Controller implements Initializable {

    private ParallelTransition pt = null;

    @FXML
    ImageView jbangLogo;

    @FXML
    public void launchWithABang() {
        if (pt != null) {
            pt.stop();
        }
        jbangLogo.setScaleX(0);
        jbangLogo.setScaleY(0);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), jbangLogo);
        scaleTransition.setFromX(0);
        scaleTransition.setToX(1.5);
        scaleTransition.setFromY(0);
        scaleTransition.setToY(1.5);
        scaleTransition.setInterpolator(Interpolator.EASE_IN);

        scaleTransition.setOnFinished((event) -> {
            prepareInifiniteAnimation();
        });
        scaleTransition.play();
    }

    private void prepareInifiniteAnimation() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), jbangLogo);
        rotateTransition.setToAngle(-5);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), jbangLogo);
        scaleTransition.setToX(0.9);
        scaleTransition.setToY(0.9);
        rotateTransition.setOnFinished((event2) -> {
            launchRepeatedAnimation();
        });
        rotateTransition.play();
        scaleTransition.play();
    }

    private void launchRepeatedAnimation() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2.5));
        rotateTransition.setAutoReverse(true);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setInterpolator(Interpolator.EASE_OUT);
        rotateTransition.setFromAngle(-5);
        rotateTransition.setToAngle(5);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2));
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.8);
        fadeTransition.setInterpolator(Interpolator.LINEAR);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1200));
        scaleTransition.setFromX(0.9);
        scaleTransition.setToX(1.1);
        scaleTransition.setFromY(0.9);
        scaleTransition.setToY(1.1);
        scaleTransition.setInterpolator(Interpolator.EASE_BOTH);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);

        pt = new ParallelTransition(jbangLogo, scaleTransition, fadeTransition, rotateTransition);
        pt.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jbangLogo.setScaleX(0);
        jbangLogo.setScaleY(0);
    }
}
