package Shapes;
import java.awt.*;
import java.util.Map;

public interface Shape {
     void setPosition(Point position);
     Point getPosition();
     void setProperties(Map<String, Double> properties);
     Map<String, Double> getProperties();
     void setColor(Color color);
     Color getColor();
     void setFillColor(Color color);
     Color getFillColor();
     void draw(java.awt.Graphics canvas);
     String toString();
}
