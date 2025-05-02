///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.openjfx:javafx-controls:21
//DEPS org.openjfx:javafx-graphics:21
//DEPS org.openjfx:javafx-fxml:21
//SOURCES Slide.java
//SOURCES Presentation.java
//SOURCES Slide1Controller.java
//SOURCES Slide3Controller.java
//FILES style.css
//FILES slide1.fxml
//FILES slide2.fxml
//FILES slide3.fxml
//FILES jbang_logo.png
//FILES devoxx-uk-illustration.png
//FILES WL_logo_turquoise.png

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class jbang_devoxxuk2025 extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        final Presentation presentation = new Presentation();
        presentation.addSlide(new Slide("slide1.fxml"));
        presentation.addSlide(new Slide("slide2.fxml"));
        presentation.addSlide(new Slide("slide3.fxml"));

        final Scene scene = new Scene(presentation);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        var keyEventHandler = new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT) {
                    presentation.previousSlidePlease();
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    presentation.nextSlidePlease();
                }
            }
        };
        scene.setOnKeyReleased(keyEventHandler);
        stage.setScene(scene);
        // stage.setFullScreen(true);
        presentation.start();
        List<Screen> screens = Screen.getScreens();
        Logger.getGlobal().log(Level.INFO, "loaded scenes {0}", screens.size());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}