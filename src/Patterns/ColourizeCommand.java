package Patterns;
import Shapes.Shape;
import javax.swing.*;
import java.awt.*;

public class ColourizeCommand implements Command {
    private final JComboBox<Shape> shapeComboBox;
    private final Shape currentShape;
    private final Color currentInnerColor;
    private final Color currentOuterColor;
    private final Color nextInnerColor;
    private final Color nextOuterColor;
    public ColourizeCommand(
                            JComboBox<Shape> shapeComboBox,
                            Shape currentShape,
                            Color nextInnerColor,
                            Color nextOuterColor) {

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
