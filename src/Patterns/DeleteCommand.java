package Patterns;

import Engine.DrawingEngine;
import GUI.Panel4;
import Shapes.Shape;
import javax.swing.*;

public class DeleteCommand implements Command {
    private DrawingEngine engine;
    private JComboBox<Shape> shapeComboBox;
    private Shape currentShape;
    private Panel4 panel4;
    public DeleteCommand(DrawingEngine engine, JComboBox<Shape> shapeComboBox, Shape currentShape, Panel4 panel4) {
        this.engine = engine;
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.panel4 = panel4;
    }

    @Override
    public void execute() {
        this.engine.removeShape(this.currentShape);
        this.shapeComboBox.removeItem(this.currentShape);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
        this.panel4.repaint();
    }

    @Override
    public void undo() {
        this.engine.addShape(this.currentShape);
        this.shapeComboBox.insertItemAt(this.currentShape,0);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
        this.panel4.repaint();
    }
}
