//FIXME: There can only be one Application thread running on a JVM at a time, therefore this should be implemented as a Scene rather than an entire new Application

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * This is where the user will enter their text, and where the resulting shorthand will be displayed. The user enters
 * an english sentence into the text field at the bottom of the stage, and then when enter is pressed, shorthand will
 * appear on the canvas in the middle of the stage.
 *
 * TODO: maybe change to every time a character is pressed? need to see how this performs first.
 * TODO: implement the actual shorthand writing
 * TODO: make this adhere to MVC
 * TODO: document
 *
 * @author Collin Tod
 */
public class Scratchpad extends Application {
    TextField txtField;
    BorderPane pane;
    Canvas canvas;
    GraphicsContext gc;

    @Override
    public void init() throws Exception {

        //Load the image files for all of the
        TextProc.loadImages();
        txtField = new TextField();
        pane = new BorderPane();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Initialize a canvas that is half the size of the screen
        canvas = new Canvas(screenBounds.getWidth()/2,screenBounds.getHeight()/2);
        gc =  canvas.getGraphicsContext2D();
        pane.setCenter(canvas);
        pane.setBottom(txtField);

        // Event handler for the text field. The action is triggered when ENTER is pressed within the textfield
        txtField.setOnAction(event -> {
            // TODO: Grab the necessary phonemes, their paired strokes
            // TODO: Then clear the canvas and repaint the correct shorthand
            // TODO: add some way for the user to toggle whether or not the shorthand renders instantly or not
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene translation = new Scene(pane);
        primaryStage.setScene(translation);

        //TODO: make this say something other than 'TEST'
        gc.drawImage(new Image("strokeFiles/strokes/Tee.png"), 10, 10);
        gc.drawImage(new Image("strokeFiles/strokes/Ess.png"), 25, 75);
        gc.drawImage(new Image("strokeFiles/strokes/Tee.png"), 10, 135);
        gc.drawImage(TextProc.strokeMap.get('R').getImage(), 100, 100);
        primaryStage.setTitle("'TEST'");
        primaryStage.show();
    }
}
