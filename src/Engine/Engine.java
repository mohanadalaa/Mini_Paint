package Engine;

import Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public interface Engine {
    void addShape(Shape shape);
    void removeShape(Shape shape);

   // Shape getShapeAt(Point position);
    ArrayList<Shape> getShapes();

    void refresh(java.awt.Graphics canvas);
}
