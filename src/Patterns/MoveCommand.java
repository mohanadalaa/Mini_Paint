package Patterns;
import Shapes.Shape;
import javax.swing.*;
import java.awt.*;

public class MoveCommand implements Command {
    private Shape currentShape;
    private JComboBox<Shape> shapeComboBox;

    private Point moveToPoint;
    private Point currentPoint;

    private Point moveEndPoint;
    private Point currentEndPoint;

    //Constructor for the rest of the shapes
    public MoveCommand( JComboBox<Shape> shapeComboBox, Shape currentShape, Point moveToPoint ) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.moveToPoint = moveToPoint;
        this.currentPoint= currentShape.getStartPoint();

    }
    //Constructor for lineSegment
    public MoveCommand( JComboBox<Shape> shapeComboBox, Shape currentShape, Point moveToPoint ,Point endPoint) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.moveToPoint = moveToPoint;
        this.currentPoint= currentShape.getStartPoint();
        this.moveEndPoint = endPoint;
        this.currentEndPoint = currentShape.getEndPoint();
    }

    @Override
    public void execute() {

        if (this.currentShape.isLineSegment()) {
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
        if(this.currentShape.isLineSegment()){
            this.currentShape.setStartPoint(currentPoint);
            this.currentShape.setEndPoint(currentEndPoint);
            this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }
        this.currentShape.setStartPoint(currentPoint);
        this.shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
