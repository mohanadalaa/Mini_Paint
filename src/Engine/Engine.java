package Engine;
import Shapes.Shape;
import java.util.ArrayList;
public interface Engine {
    void addShape(Shape shape);
    void removeShape(Shape shape);
    ArrayList<Shape> getShapes();
    void refresh(java.awt.Graphics canvas);
}
