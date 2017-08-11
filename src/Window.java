import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{
    final private Dimension d = new Dimension(1000,1000);

    public Window(){
        this.setVisible(true);
        this.setSize(d);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        build();
    }

    private void build(){
        Canvas canv = new Canvas();
        add(canv);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
