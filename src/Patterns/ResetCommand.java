package Patterns;


import GUI.Gui;
import Shapes.SelectedShape;
import Shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ResetCommand implements Command {

    private final Gui gui;
    private List<Shape> backupShape;
    private final Stack<Command> backupUndoStack= new Stack<>();

    public ResetCommand(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void execute() {

        if(this.gui.engine.getShapes()==null) return;
        if(this.gui.shapeComboBox.getItemCount()==1) return;

        backupShape = new ArrayList<>(this.gui.engine.getShapes());

        // now i have the shapes backed up for future use
        this.gui.engine.clearTheList();
        this.gui.shapeComboBox.removeAllItems();
        this.gui.shapeComboBox.addItem(new SelectedShape());
        this.gui.shapeComboBox.setSelectedIndex(this.gui.shapeComboBox.getItemCount() - 1);
        this.gui.panel4.repaint();

        while (!this.gui.undoStack.isEmpty())
            this.backupUndoStack.push(this.gui.undoStack.pop());


    }

    @Override
    public void undo() {
        if (backupShape != null) {
            this.gui.engine.clearTheList();
            this.gui.shapeComboBox.removeAllItems();
            for (Shape shape : backupShape) {
                this.gui.engine.addShape(shape);
                this.gui.shapeComboBox.insertItemAt(shape,0);
            }
            this.gui.shapeComboBox.addItem(new SelectedShape());
            this.gui.shapeComboBox.setSelectedIndex(this.gui.shapeComboBox.getItemCount() - 1);
            this.gui.panel4.repaint();

            while (!this.backupUndoStack.isEmpty())
                this.gui.undoStack.push(this.backupUndoStack.pop());

        }
    }
}
