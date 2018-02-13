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

    public Stroke(String url, int x1, int y1, int x2, int y2){
        this(url, new Point(x1,y1), new Point(x2, y2));
    }

    public Stroke(String url, Point start, Point end){
        this.image = new Image(url);
        this.start = start;
        this.end = end;
    }


    /**
     * Returns the visual stroke
     *
     * @return The image that is to be displayed when representing the stroke
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image
     *
     * @param image The image that the stroke's image is to be set to
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Gets the starting point of the stroke within its 80 x 80 png
     *
     * @return The starting point
     */
    public Point getStart() {
        return start;
    }

    /**
     * Sets the starting point of the stroke
     *
     * @param start the point to be set to
     */
    public void setStart(Point start) {
        this.start.setLocation(start);
    }

    /**
     * Sets the ending point of the stroke based on coordinates, not another {@code Point}
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setStart(int x, int y){
        start.setLocation(x,y);
    }
    /**
     * Gets the ending point of the stroke within its 80 x 80 png
     *
     * @return The ending point
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Sets the ending point of the stroke
     *
     * @param end the point to be set to
     */
    public void setEnd(Point end) {
        this.end.setLocation(end);
    }

    /**
     * Sets the ending point of the stroke based on coordinates, not another {@code Point}
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void setEnd(int x, int y){
       this.end.setLocation(x, y);
    }

    /**
     * Gets the horizontal span of a stroke.
     *
     * @return the x coordinate of the ending point minus the x coordinate of the y coordinate
     */
    public int getLength(){
        return end.x - start.x;
    }

}
