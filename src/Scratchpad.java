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

import javax.xml.soap.Text;
import java.util.concurrent.TransferQueue;

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
        canvas = new Canvas(screenBounds.getWidth(),screenBounds.getHeight() -100);
        gc =  canvas.getGraphicsContext2D();
        pane.setCenter(canvas);
        pane.setBottom(txtField);

        //TODO: make this understand shorthand better, and maybe move the whole thing to its own method since it'll be so long
        // Event handler for the text field. The action is triggered when ENTER is pressed within the textfield
        txtField.setOnAction(event -> {

            // Clear all of the previous drawings
            gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());


            Character[][] phones = TextProc.phones(txtField.getText());
            int x = 0;
            int y;
            Stroke current;

            //Iterate through the sentence
            for (Character[] word : phones) {

                // Iterate through the word
                for (Character c : word) {

                    // Don't bother with the vowels yet, only draw outlines.
                    if (!TextProc.isVowel(c)) {
                        current = TextProc.strokeMap.get(c);

                        // Move the image over 80 px
                        x += 80;

                        // Calculate which line the image should be on
                        y = 80 * (x / (int) screenBounds.getWidth());

                        // Draw the image
                        gc.drawImage(current.getImage(), Math.round((x) % screenBounds.getWidth()), y);
                    }
                }

                // Put 80 pixels in between words to fo indicate a space until joining is funtioning
                x += 80;
            }

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
        primaryStage.setTitle("'TEST'");
        primaryStage.show();
    }
}
