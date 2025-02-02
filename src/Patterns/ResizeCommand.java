package Patterns;

import Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ResizeCommand implements Command {


    private final JComboBox<Shape> shapeComboBox;
    private final Shape currentShape;

    private final Map<String, Double> propertiesAfter = new HashMap<>();
    private Map<String, Double> propertiesBefore;

    //lineSegment variables
    private Point newEndPoint;
    private Point oldEndPoint;

    //constructor for rectangle
    public ResizeCommand(JComboBox<Shape> shapeComboBox, Shape currentShape,int length,int width) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.propertiesBefore=this.currentShape.getProperties();
        this.propertiesAfter.put("height", (double) length);
        this.propertiesAfter.put("width", (double) width);

    }
    //constructor for Square and Circle
    public ResizeCommand( JComboBox<Shape> shapeComboBox, Shape currentShape,int length) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        if(currentShape.type().equals("Square")) {
            this.propertiesAfter.put("length", (double) length);
        }
        if(currentShape.type().equals("Circle")) {
            this.propertiesAfter.put("radius", (double) length);
        }
        this.propertiesBefore=this.currentShape.getProperties();
    }
    //constructor for Line segment
    public ResizeCommand(JComboBox<Shape> shapeComboBox, Shape currentShape, Point endPoint) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.newEndPoint = endPoint;
        this.oldEndPoint = this.currentShape.getEndPoint();
    }

    @Override
    public void execute() {
        //line segment Condition
        if (this.currentShape.type().equals("Segment")) {
            this.currentShape.setEndPoint(newEndPoint);
            this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }

        this.currentShape.setProperties(this.propertiesAfter);
        this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
        //line segment Condition
        if (this.currentShape.type().equals("Segment")) {
            this.currentShape.setEndPoint(oldEndPoint);
            this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }
        this.currentShape.setProperties(this.propertiesBefore);
        this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
