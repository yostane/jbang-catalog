import java.util.List;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class PresentationContainer extends Pane {

    private List<Slide> slides;
    private int index = 0;
    private Slide current;

    public PresentationContainer(List<Slide> slides) {
        this.slides = slides;
    }

    public void previousSlidePlease() {
        if (index > 0) {
            index--;
        }
        setSlide(index);
    }

    public void nextSlidePlease() {
        if (index < slides.size() - 1) {
            index++;
        }
        setSlide(index);
    }

    public void setSlide(int index) {
        if (current != null) {
            getChildren().remove(current);
        }
        current = slides.get(index);
        scaleToFitKeepingRatio();
        getChildren().add(slides.get(index));
        current.requestFocus();
    }

    void start() {
        index = -1;
        nextSlidePlease();
    }

    private void scaleToFitKeepingRatio() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double prefWidth = current.getPrefWidth();
        double prefHeight = current.getPrefHeight();
        double scaleX = screenBounds.getWidth() / prefWidth;
        double scaleY = screenBounds.getHeight() / prefHeight;
        double scale = Math.min(scaleX, scaleY);
        double centerX = (screenBounds.getWidth() / 2) - (prefWidth / 2);
        double centerY = (screenBounds.getHeight() / 2) - (prefHeight / 2);
        current.setTranslateX(centerX);
        current.setTranslateY(centerY);
        current.setScaleX(scale);
        current.setScaleY(scale);
    }
}