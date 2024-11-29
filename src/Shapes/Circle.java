package Shapes;

import java.awt.*;


public class Circle extends Shape {


    public Circle(double radius,Point position)
    {
        super(position);
        this.properties.put("radius", radius);
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

    @Override
    public String type() {
        return "Circle";
    }
}
