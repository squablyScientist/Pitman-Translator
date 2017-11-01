// FIXME make this not centered around the landing page since only one application can be on a JFX thread at a time
package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A simple landing page that welcomes the user and gives an enter button.
 * TODO: make closing the window do something different than the enter button
 * TODO: make the whole thing look nicer
 * TODO: Add initial size for the stage
 * TODO: move setup to init()
 * TODO: Document
 *
 * @author Collin Tod
 */
public class Landing extends Application {

    public Landing() {
        super();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label welMessage = new Label("Welcome to Collin Tod's Pitman Shorthand Translator!");
        Button enter = new Button("Enter");
        VBox pane = new VBox(5);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(welMessage, enter);
        Scene welcome = new Scene(pane);

        enter.setOnAction(event -> {
            try {
                Platform.exit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        primaryStage.setScene(welcome);
        primaryStage.setTitle("Welcome to the Pitman Translator!");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
