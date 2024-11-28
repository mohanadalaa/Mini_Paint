package Shapes;

import java.awt.*;

public class Square extends Shape {


    public Square(double length, Point position) {
        super(position);
        properties.put("length", length);
    }


    @Override
    public void setEndPoint(Point endPoint) {

    }

    @Override
    public Point getEndPoint() {
        return null;
    }

    @Override
    public void draw(Graphics canvas) {
        int length = (int)this.properties.get("length").doubleValue();
        int x = this.startPoint.x;
        int y = this.startPoint.y;

        if(this.color!=null){
            canvas.setColor(this.color);
            canvas.drawRect(x,y,length,length);
        }
        if(this.fillColor!=null){
            canvas.setColor(this.fillColor);
            canvas.fillRect(x,y,length,length);
        }
    }

    @Override
    public String type() {
        return "Square";
    }

}
