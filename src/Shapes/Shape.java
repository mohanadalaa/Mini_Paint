package Shapes;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public  abstract class Shape implements ShapeInter, Serializable {

    protected Point startPoint;
    protected Color color;
    protected Color fillColor;
    protected Map<String, Double> properties;
    protected int indx;

    public Shape(Point startPoint) {
        this.startPoint = startPoint;
        this.color = Color.BLACK;
        properties = new HashMap<>();
        this.indx = 0;
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
    public abstract void setEndPoint(Point endPoint) ;
    @Override
    public abstract Point getEndPoint() ;
    @Override
    public abstract void  draw(Graphics canvas) ;
    @Override
    public abstract String type();


    public String toString()
    {
        return type()+indx;
    }

    public int getIndx() {
        return indx;
    }

    public void setIndx(int indx) {
        this.indx = indx;
    }

}
