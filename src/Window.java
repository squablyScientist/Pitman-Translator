import javax.swing.*;
import java.awt.*;


public class Window extends JFrame{
    final private Dimension d = new Dimension(1000,1000);

    public Window(){
        this.setVisible(true);
        this.setSize(d);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        build();
    }

    private void build(){

    }
}
