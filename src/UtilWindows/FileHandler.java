package UtilWindows;

import GUI.Gui;
import Shapes.Shape;


import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private String fileName;
    private Gui gui;
    public FileHandler(String fileName,Gui gui) {
        this.fileName = fileName;
        this.gui = gui;
    }

    public  void SaveToFile() {
        ArrayList<Shape> list = gui.engine.getShapes();

        if (list.isEmpty()) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(this.fileName, false)) {
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        try (FileOutputStream fileOut = new FileOutputStream(this.fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Shape shape : list) {
                out.writeObject(shape);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void LoadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileName))) {
            while (true) {
                try {
                    Shape loadedShape = (Shape) ois.readObject();
                    gui.engine.getShapes().add(loadedShape);
                    gui.shapeComboBox.insertItemAt(loadedShape, 0);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading shapes File might be Empty");
        }
        gui.panel4.repaint();
    }

}
