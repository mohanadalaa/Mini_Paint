package Shapes;

import java.awt.*;


public class Rectangle extends Shape {



    public Rectangle(double height,double width, Point position) {
        super(position);
        this.properties.put("height", height);
        this.properties.put("width", width);
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
    public String type() {
        return "Rectangle";
    }

}
