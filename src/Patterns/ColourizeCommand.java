package Patterns;

import Engine.DrawingEngine;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class ColourizeCommand implements Command {
    private DrawingEngine engine;
    private JComboBox<Shape> shapeComboBox;
    private Shape currentShape;
    private Color currentColor;
    private Color nextColor;
    public ColourizeCommand(DrawingEngine engine, JComboBox<Shape> shapeComboBox,Shape currentShape,Color nextColor) {
        this.engine = engine;
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.currentColor = this.currentShape.getFillColor();
        this.nextColor = nextColor;
    }

    @Override
    public void execute() {
       // this.currentShape.setColor(this.nextColor);
        this.currentShape.setFillColor(this.nextColor);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
       // this.currentShape.setColor(this.currentColor);
        this.currentShape.setFillColor(this.currentColor);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
