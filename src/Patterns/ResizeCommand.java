package Patterns;

import Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ResizeCommand implements Command {


    private JComboBox<Shape> shapeComboBox;
    private Shape currentShape;

    private Map<String, Double> propertiesAfter = new HashMap<>();
    private Map<String, Double> propertiesBefore;

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
        if(currentShape.isSquare()) {
            this.propertiesAfter.put("length", (double) length);
        }
        if(currentShape.isCircle()) {
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
        if (this.currentShape.isLineSegment()) {
            this.currentShape.setEndPoint(newEndPoint);
            this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }

        this.currentShape.setProperties(this.propertiesAfter);
        this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
        if (this.currentShape.isLineSegment()) {
            this.currentShape.setEndPoint(oldEndPoint);
            this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }
        this.currentShape.setProperties(this.propertiesBefore);
        this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
