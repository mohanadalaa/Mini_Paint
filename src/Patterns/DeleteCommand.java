package Patterns;

import Engine.DrawingEngine;
import Shapes.Shape;
import javax.swing.*;

public class DeleteCommand implements Command {
    private DrawingEngine engine;
    private JComboBox<Shape> shapeComboBox;
    private Shape currentShape;
    public DeleteCommand(DrawingEngine engine, JComboBox<Shape> shapeComboBox,Shape currentShape) {
        this.engine = engine;
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
    }

    @Override
    public void execute() {
        this.engine.removeShape(this.currentShape);
        this.shapeComboBox.removeItem(this.currentShape);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
        this.engine.addShape(this.currentShape);
        this.shapeComboBox.insertItemAt(this.currentShape,0);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
