package Engine;

import Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

public class DrawingEngine implements Engine{

    private ArrayList<Shape> list;
    public DrawingEngine(){
        this.list=new ArrayList<>();
    }

    @Override
    public void addShape(Shape shape) {
        this.list.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        this.list.remove(shape);
    }

    @Override
    public ArrayList<Shape> getShapes() {
        return this.list;
    }


    @Override
    public void refresh(java.awt.Graphics canvas ) {
        for(Shape shape : this.list){
            shape.draw(canvas);
        }
    }
}
