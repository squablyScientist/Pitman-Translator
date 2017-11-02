import javafx.application.Application;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        TextProc.load();
        Application.launch(Scratchpad.class, args);
    }

}