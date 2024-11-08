package Patterns;

import Engine.DrawingEngine;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class ColourizeCommand implements Command {
    private DrawingEngine engine;
    private JComboBox<Shape> shapeComboBox;
    private Shape currentShape;
    private Color currentInnerColor;
    private Color currentOuterColor;
    private Color nextInnerColor;
    private Color nextOuterColor;
    public ColourizeCommand(DrawingEngine engine,
                            JComboBox<Shape> shapeComboBox,
                            Shape currentShape,
                            Color nextInnerColor,
                            Color nextOuterColor) {
        this.engine = engine;
        this.shapeComboBox = shapeComboBox;
        this.currentShape = currentShape;
        this.currentInnerColor = this.currentShape.getFillColor();
        this.currentOuterColor = this.currentShape.getColor();
        this.nextInnerColor = nextInnerColor;
        this.nextOuterColor = nextOuterColor;
    }

    @Override
    public void execute() {
        this.currentShape.setColor(this.nextOuterColor);
        this.currentShape.setFillColor(this.nextInnerColor);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }

    @Override
    public void undo() {
        this.currentShape.setColor(this.currentOuterColor);
        this.currentShape.setFillColor(this.currentInnerColor);
        shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
    }
}
