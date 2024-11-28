package UtilWindows;

import GUI.Gui;
import Patterns.ResetCommand;
import Shapes.Shape;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private final String filePath;
    private final Gui gui;
    public FileHandler(String filePath, Gui gui) {
        this.filePath = filePath;
        this.gui = gui;
    }

    public  void SaveToFile() {
        ArrayList<Shape> list = gui.engine.getShapes();

        //if list empty clear the file
        if (list.isEmpty()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.filePath, false);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        //fill the file
        try (FileOutputStream fileOut = new FileOutputStream(this.filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
             for (Shape shape : list) {
                out.writeObject(shape);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Saved to " + filePath);
    }

    public  void LoadFromFile() {

        if (!this.gui.engine.getShapes().isEmpty())
        {
            int result = JOptionPane.showConfirmDialog(
                    null, // Parent component (null for center of the screen)
                    "Current shapes will be Lost you want to proceed?", // Message to display
                    "Confirmation", // Title of the dialog box
                    JOptionPane.YES_NO_OPTION, // Option type (Yes/No buttons)
                    JOptionPane.QUESTION_MESSAGE // Message type (icon)
            );

            if (result == JOptionPane.YES_OPTION) {
                new ResetCommand(this.gui).execute();
            } else if (result == JOptionPane.NO_OPTION) {
                return;
            } else {
                return;
            }
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filePath))) {
            while (true) {
                try {
                    Shape loadedShape = (Shape) ois.readObject();
                    gui.engine.addShape(loadedShape);
                    gui.shapeComboBox.insertItemAt(loadedShape, 0);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null,"Error loading shapes File might be Empty","error",JOptionPane.ERROR_MESSAGE);
           return;
        }
        gui.panel4.repaint();
        JOptionPane.showMessageDialog(null, "Loaded from " + filePath);
    }

}
