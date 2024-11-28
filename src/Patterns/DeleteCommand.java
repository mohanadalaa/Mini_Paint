package Patterns;

import Engine.DrawingEngine;
import GUI.Panel4;
import Shapes.Shape;
import javax.swing.*;

public class DeleteCommand implements Command {
    private final DrawingEngine engine;
    private final JComboBox<Shape> shapeComboBox;
    private final Shape currentShape;
    private final Panel4 panel4;
    private final int index;
    public DeleteCommand(DrawingEngine engine, JComboBox<Shape> shapeComboBox, Shape currentShape, Panel4 panel4) {
        this.engine = engine;
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.panel4 = panel4;
        this.index=engine.getShapes().indexOf(currentShape);
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
        this.engine.addShape(this.currentShape,index);
        this.shapeComboBox.insertItemAt(this.currentShape,0);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
        this.panel4.repaint();
    }
}
