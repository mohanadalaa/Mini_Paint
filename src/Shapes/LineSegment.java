package Shapes;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LineSegment implements Shape {

    private static int NUMBER_OF_LINE_SEGMENTS = 0;
    private int indx;
    private Point startPoint;
    private Point endPoint;
    private Color color;
    private Map<String, Double> properties;

    public LineSegment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = Color.BLACK;
        properties = new HashMap<>();
        properties.put("length", startPoint.distance(endPoint));
        indx = NUMBER_OF_LINE_SEGMENTS;
        NUMBER_OF_LINE_SEGMENTS++;
    }

    @Override
    public void setPosition(Point position) {
      this.startPoint = position;
    }

    @Override
    public Point getPosition() {
        return this.startPoint;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return this.properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
    }

    @Override
    public Color getFillColor() {
        return null;
    }

    @Override
    public void draw(Graphics canvas) {
        if (this.color != null) {
            canvas.setColor(this.color);
            canvas.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
        }
    }

    @Override
    public String toString() {
        return "LineSegment" + indx;
    }
}
