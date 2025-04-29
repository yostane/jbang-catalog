import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;

public class Presentation extends Group {

    private List<Slide> slides = new ArrayList<>();
    private int index;
    private Slide current;
    public EventHandler<KeyEvent> keyEventHandler;

    public void addSlide(Slide slide) {
        addSlide(slides.size(), slide);
    }

    public void addSlide(int index, Slide slide) {
        slides.add(index, slide);
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
        scaleToFit();
        getChildren().add(slides.get(index));
        current.requestFocus();
    }

    void start() {
        index = -1;
        nextSlidePlease();
    }

    private void scaleToFit() {
        javafx.geometry.Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double prefWidth = current.getPrefWidth();
        double prefHeight = current.getPrefHeight();
        double scaleX = screenBounds.getWidth() / prefWidth;
        double scaleY = screenBounds.getHeight() / prefHeight;
        double centerX = (screenBounds.getWidth() / 2) - (prefWidth / 2);
        double centerY = (screenBounds.getHeight() / 2) - (prefHeight / 2);
        setTranslateX(centerX);
        setTranslateY(centerY);
        setScaleX(scaleX);
        setScaleY(scaleY);
    }
}