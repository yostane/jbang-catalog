///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.openjfx:javafx-controls:21
//DEPS org.openjfx:javafx-graphics:21
//DEPS org.openjfx:javafx-fxml:21
//JAVA 21
//SOURCES Slide.java
//SOURCES Presentation.java
//SOURCES Slide1Controller.java
//FILES style.css
//FILES slide1.fxml
//FILES slide2.fxml

import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class JFXPresentation extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        List<Slide> slides = List.of(
                new Slide("slide1.fxml"),
                new Slide("slide2.fxml"));

        final Presentation presentation = new Presentation(slides);
        final Scene scene = new Scene(presentation);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT) {
                    presentation.previousSlidePlease();
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    presentation.nextSlidePlease();
                }
            }
        });
        stage.setScene(scene);
        stage.setFullScreen(true);
        presentation.start();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}