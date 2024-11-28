package Patterns;
import Shapes.Shape;
import javax.swing.*;
import java.awt.*;

public class MoveCommand implements Command {
    private final Shape currentShape;
    private final JComboBox<Shape> shapeComboBox;

    private final Point moveToPoint;
    private final Point currentPoint;

    private Point moveEndPoint;
    private Point currentEndPoint;

    //Constructor for lineSegment
    public MoveCommand( JComboBox<Shape> shapeComboBox, Shape currentShape, Point moveToPoint ,Point endPoint) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.moveToPoint = moveToPoint;
        this.currentPoint= currentShape.getStartPoint();
        this.moveEndPoint = endPoint;
        this.currentEndPoint = currentShape.getEndPoint();
    }

    //Constructor for the rest of the shapes
    public MoveCommand( JComboBox<Shape> shapeComboBox, Shape currentShape, Point moveToPoint ) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.moveToPoint = moveToPoint;
        this.currentPoint= currentShape.getStartPoint();

    }


    @Override
    public void execute() {

        if (this.currentShape.type().equals("Segment")) {
            this.currentShape.setStartPoint(moveToPoint);
            this.currentShape.setEndPoint(moveEndPoint);
            this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }
        this.currentShape.setStartPoint(moveToPoint);
        this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
        if(this.currentShape.type().equals("Segment")){
            this.currentShape.setStartPoint(currentPoint);
            this.currentShape.setEndPoint(currentEndPoint);
            this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }
        this.currentShape.setStartPoint(currentPoint);
        this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
