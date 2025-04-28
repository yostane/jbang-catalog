///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.openjfx:javafx-controls:21
//DEPS org.openjfx:javafx-graphics:21
//DEPS org.openjfx:javafx-fxml:21
//JAVA 21
//SOURCES Slide.java
//SOURCES Presentation.java
//FILES style.css
//FILES slide1.fxml
//FILES slide2.fxml

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class JfxPresentation extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        final Presentation presentation = new Presentation();
        presentation.addSlide(new Slide("slide1.fxml"));
        presentation.addSlide(new Slide("slide2.fxml"));

        final Scene scene = new Scene(presentation);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setFullScreen(true);
        presentation.start();
        List<Screen> screens = Screen.getScreens();
        Logger.getGlobal().log(Level.INFO, "loaded scenes 0", screens.size());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}