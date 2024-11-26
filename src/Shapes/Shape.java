package Shapes;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public  abstract class Shape implements ShapeInter {


    protected Point startPoint;
    protected Color color;
    protected Color fillColor;
    protected Map<String, Double> properties;
    public Shape(Point startPoint) {
        this.startPoint = startPoint;
        this.color = Color.BLACK;
        properties = new HashMap<>();
    }
    protected Shape(){

    }
    @Override
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public Point getStartPoint() {
        return this.startPoint;
    }

    @Override
    public abstract void setEndPoint(Point endPoint) ;

    @Override
    public abstract Point getEndPoint() ;

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
    public abstract void  draw(Graphics canvas) ;

    public abstract boolean isLineSegment();
    public abstract boolean isSquare();
    public abstract boolean isRectangle();
    public abstract boolean isCircle();


}
