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
    public boolean isLineSegment() {
        return false;
    }

    @Override
    public boolean isSquare() {
        return false;
    }

    @Override
    public boolean isRectangle() {
        return false;
    }

    @Override
    public boolean isCircle() {
        return false;
    }


    public String toString()
    {
        return "Select a Shape";
    }
}
