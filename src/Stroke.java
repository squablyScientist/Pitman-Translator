import javafx.scene.image.Image;

import java.awt.*;

/**
 * Stroke.java
 *
 * A class to hold a stroke file, as well as all of its relevant information.
 *
 * @author Collin Tod
 */
public class Stroke {
    private Image image;
    private Point start;
    private Point end;

    public Stroke(String url, Point start, Point end){
        this.image = new Image(url);
        this.start = start;
        this.end = end;
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start.setLocation(start);
    }

    public void setStart(int x, int y){
        start.setLocation(x,y);
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end.setLocation(end);
    }

    public void setEnd(int x, int y){
       this.end.setLocation(x, y);
    }
}
