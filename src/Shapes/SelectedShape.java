package Shapes;

import java.awt.*;
import java.util.Map;

public class SelectedShape implements Shape {
    @Override
    public void setPosition(Point position) {

    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {

    }

    @Override
    public Map<String, Double> getProperties() {
        return Map.of();
    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public Color getColor() {
        return null;
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

    }

    public String toString()
    {
        return "Select a Shape";
    }
}
