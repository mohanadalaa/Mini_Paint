package Shapes;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Square implements Shape {

    private static  int NUMBER_OF_SQUARES=0;
    private int indx;
    private Point position;
    private Color color;
    private Color fillColor;
    private Map<String, Double> properties;

    public Square(double length, Point position) {
        this.color = Color.BLACK;
        this.position = position;
        properties = new HashMap<>();
        properties.put("length", length);
        indx=NUMBER_OF_SQUARES;
        NUMBER_OF_SQUARES++;
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
            this.color=color;
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
        int length = (int)this.properties.get("length").doubleValue();
        int x = this.position.x;
        int y = this.position.y;

        if(this.color!=null){
            canvas.setColor(this.color);
            canvas.drawRect(x,y,length,length);
        }
        if(this.fillColor!=null){
            canvas.setColor(this.fillColor);
            canvas.fillRect(x,y,length,length);
        }
    }
    public String toString() {
        return "Square"+indx;
    }
}
