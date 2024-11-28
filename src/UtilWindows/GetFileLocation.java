package UtilWindows;

import GUI.Gui;

import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;

public class GetFileLocation {
    private Gui gui;

    public GetFileLocation(Gui gui, boolean save, boolean load) {
        this.gui = gui;

        // Create JFileChooser instance
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));

        // Show Save Dialog
        int result = fileChooser.showSaveDialog(null);

        // If the user clicked "Save"
        if (result == JFileChooser.APPROVE_OPTION) {

            // Get the selected file
            File file = fileChooser.getSelectedFile();

            // Check if the user entered a file name or selected a file
            if (file == null || file.getName().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No file name entered. Please provide a valid file name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Ensure the file has a proper .txt extension
            if (!file.getName().endsWith(".txt")) {
                file = new File(file.getAbsolutePath() + ".txt");
            }

            // If in save mode, create the file if it doesn't exist
            if (save) {
                if (!file.exists()) {
                    try {
                        boolean fileCreated = file.createNewFile();
                        if (fileCreated) {
                            JOptionPane.showMessageDialog(null, "File Created Successfully.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error creating the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // If in load mode, ensure the file exists
            if (load) {
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null, "The selected file does not exist. Please select a valid file.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String filePath = file.getAbsolutePath();
            FileHandler fileHandler = new FileHandler(filePath, gui);

            if (save) {
                fileHandler.SaveToFile(); // Save to the selected file

            }
            if (load) {
                fileHandler.LoadFromFile(); // Load from the selected file
            }
        } else {
            // Show an error if the user cancels or closes the dialog
            JOptionPane.showMessageDialog(null, "No file selected. Please select a valid file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
