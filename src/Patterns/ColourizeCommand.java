package Patterns;

import Engine.DrawingEngine;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class ColourizeCommand implements Command {
    private DrawingEngine engine;
    private JComboBox<Shape> shapeComboBox;
    private Shape currentShape;
    private Color color;
    public ColourizeCommand(DrawingEngine engine, JComboBox<Shape> shapeComboBox,Shape currentShape,Color color) {
        this.engine = engine;
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.color = color;
    }

    @Override
    public void execute() {
        this.currentShape.setColor(this.color);
        this.currentShape.setFillColor(this.color);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
        this.currentShape.setColor(Color.BLACK);
        this.currentShape.setFillColor(Color.WHITE);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
