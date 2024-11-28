package Shapes;

import java.awt.*;

public class SelectedShape extends Shape {
    public SelectedShape() {
        super();
    }

    @Override
    public void setEndPoint(Point endPoint) {
    }

    @Override
    public Point getEndPoint() {
        return null;
    }

    @Override
    public void draw(Graphics canvas) {

    }

    @Override
    public String type() {
        return null;
    }





    public String toString()
    {
        return "Select a Shape";
    }
}
