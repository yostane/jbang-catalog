import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Slide extends AnchorPane {

    public Slide(String slide) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(slide));
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }
}