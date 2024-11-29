package Shapes;

import java.awt.*;


public class LineSegment extends Shape {


    private Point endPoint;


    public LineSegment(Point startPoint, Point endPoint) {
       super(startPoint);
        this.endPoint = endPoint;
        properties.put("length", startPoint.distance(endPoint));

    }
    @Override
    public void setFillColor(Color color) {
    }

    @Override
    public Color getFillColor() {
        return null;
    }
    @Override
    public Point getEndPoint() {
        return this.endPoint;
    }
    @Override
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics canvas) {
        if (this.color != null) {
            canvas.setColor(this.color);
            canvas.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
        }
    }

    @Override
    public String type() {
        return "Segment";
    }

}
