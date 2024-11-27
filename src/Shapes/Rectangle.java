package Shapes;

import java.awt.*;


public class Rectangle extends Shape {

    private static  int NUMBER_OF_RECTANGLES=0;
    private int indx;

    public Rectangle(double height,double width, Point position) {
        super(position);
        this.properties.put("height", height);
        this.properties.put("width", width);
        indx=NUMBER_OF_RECTANGLES;
        NUMBER_OF_RECTANGLES++;
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
        double width = this.properties.get("width");
        double height = this.properties.get("height");
        int x = this.startPoint.x;
        int y = this.startPoint.y;

        if (this.color != null) {
            canvas.setColor(this.color);
            canvas.drawRect(x, y, (int) width, (int) height);
        }

        if (this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillRect(x, y, (int) width, (int) height);
        }
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
        return true;
    }

    @Override
    public boolean isCircle() {
        return false;
    }



    public String toString() {
        return "Rectangle"+indx;
    }
}
