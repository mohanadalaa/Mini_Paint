package Shapes;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Circle implements Shape {

    private Point position;
    private Color color;
    private Color fillColor;
    private Map<String, Double> properties;

    public Circle(double radius,Point position)
    {
        this.position = position;
        this.color = Color.WHITE;
        this.properties = new HashMap<>();
        this.properties.put("radius", radius);
    }

    @Override
    public void setPosition(Point position) {
            this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
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
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void draw(Graphics canvas) {
        double radius = this.properties.get("radius");
        double xCor = this.position.x - radius;
        double yCor = this.position.y - radius;
        int diameter = (int) (2 * radius);
        int x = (int) xCor;
        int y = (int) yCor;

        // Set the color for the outline
        canvas.setColor(this.color);
        canvas.drawOval(x, y, diameter, diameter);

        // Set the color for the fill
        if (this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillOval(x, y, diameter, diameter);
        }
    }


}
