package Patterns;


import GUI.Gui;
import Shapes.SelectedShape;
import Shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class ResetCommand implements Command {

    private Gui gui;
    private List<Shape> backupShape;
    private List<Shape> backupComboBoxItems;

    public ResetCommand(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void execute() {

        if(this.gui.engine.getShapes()==null) return;
        if(this.gui.shapeComboBox.getItemCount()==1) return;

        backupShape = new ArrayList<>(this.gui.engine.getShapes());
        backupComboBoxItems = new ArrayList<>();
        for (int i = 0; i < this.gui.shapeComboBox.getItemCount(); i++) {
            backupComboBoxItems.add(this.gui.shapeComboBox.getItemAt(i));
        }

        // now i have the shapes backed up for future use

        this.gui.engine.getShapes().clear();
        this.gui.shapeComboBox.removeAllItems();
        this.gui.shapeComboBox.addItem(new SelectedShape());
        this.gui.shapeComboBox.setSelectedIndex(this.gui.shapeComboBox.getItemCount() - 1);
        this.gui.panel4.repaint();


    }

    @Override
    public void undo() {
        if (backupShape != null && backupComboBoxItems != null) { //
            this.gui.engine.getShapes().clear();
            this.gui.engine.getShapes().addAll(backupShape);

            this.gui.shapeComboBox.removeAllItems();
            for (Shape shape : backupComboBoxItems) {
                this.gui.shapeComboBox.addItem(shape);
            }

            if (!backupComboBoxItems.isEmpty()) {
                this.gui.shapeComboBox.setSelectedIndex(backupComboBoxItems.size() - 1);
            }
            this.gui.panel4.repaint();
        }
    }
}
