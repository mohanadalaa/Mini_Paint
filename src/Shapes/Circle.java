package Shapes;

import java.awt.*;


public class Circle extends Shape {

    private static  int NUMBER_OF_CIRCLES=0;
    private int indx;

    public Circle(double radius,Point position)
    {
        super(position);
        this.properties.put("radius", radius);
        this.indx=NUMBER_OF_CIRCLES;
        NUMBER_OF_CIRCLES++;
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
        double radius = this.properties.get("radius");
        double x = this.startPoint.x - radius;
        double y = this.startPoint.y - radius;

        int diameter = (int) (2 * radius);

        if(this.color != null) {
            canvas.setColor(this.color);
            canvas.drawOval((int)x, (int)y, diameter, diameter);
        }

        if (this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillOval((int)x,(int)y, diameter, diameter);
        }
    }
    public String toString() {
        return "Circle"+indx;
    }

}
