package Patterns;
import Shapes.Shape;
import javax.swing.*;
import java.awt.*;

public class MoveCommand implements Command {
    private Shape currentShape;
    private JComboBox<Shape> shapeComboBox;

    private Point moveToPoint;
    private Point currentPoint;

    private boolean isLineSegment;
    private Point moveEndPoint;
    private Point currentEndPoint;

    public MoveCommand( JComboBox<Shape> shapeComboBox, Shape currentShape, Point moveToPoint ,Point endPoint) {
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.moveToPoint = moveToPoint;
        this.currentPoint= currentShape.getStartPoint();
        this.isLineSegment = false;

        if (endPoint != null) { //LineSegment Validation
            this.isLineSegment = true;
            this.moveEndPoint = endPoint;
            this.currentEndPoint = currentShape.getEndPoint();
        }
    }

    @Override
    public void execute() {

        if (this.isLineSegment) {
            this.currentShape.setStartPoint(moveToPoint);
            this.currentShape.setEndPoint(moveEndPoint);
            shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }
        this.currentShape.setStartPoint(moveToPoint);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
        if(this.isLineSegment){
            this.currentShape.setStartPoint(currentPoint);
            this.currentShape.setEndPoint(currentEndPoint);
            shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
            return;
        }
        this.currentShape.setStartPoint(currentPoint);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
