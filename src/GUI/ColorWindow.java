package GUI;


import Patterns.ColourizeCommand;

import javax.swing.*;
import java.awt.*;


public class ColorWindow extends javax.swing.JFrame {

    private Gui gui;
    public ColorWindow(Gui gui) {
        this.gui = gui;
        initComponents();
        this.setTitle("Color Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Save");
        jButton2.setText("Cancel");

        jButton1.addActionListener(this::jButton1ActionPerformed);


        jButton2.addActionListener(this::jButton2ActionPerformed);

        jRadioButton1.addActionListener(this::jRadioButton1ActionPerformed);
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);

        jRadioButton1.setText("Inner Color");
        jRadioButton2.setText("Outer Color");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jButton1)
                                .addGap(63, 63, 63)
                                .addComponent(jButton2)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton1)
                                                .addGap(12, 12, 12)
                                                .addComponent(jRadioButton2)))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }

    private boolean innerValid = false;
    private boolean outerValid = false;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {


        if(innerValid==false && outerValid==false){
            JOptionPane.showMessageDialog(null,
                    "Please enter Area to Color",
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        ColourizeCommand colourizeCommand;
        Color chosenColor;

        if(innerValid==true && outerValid==false){
            chosenColor = jColorChooser1.getColor();
            colourizeCommand = new ColourizeCommand(gui.engine,
                    gui.shapeComboBox,
                    gui.currentShape,
                    chosenColor,
                    gui.currentShape.getColor());
            colourizeCommand.execute();
            this.gui.undoStack.push(colourizeCommand);
        }
        if(innerValid==false && outerValid==true){
            chosenColor = jColorChooser1.getColor();
            colourizeCommand = new ColourizeCommand(gui.engine,
                    gui.shapeComboBox,
                    gui.currentShape,
                    gui.currentShape.getFillColor(),
                    chosenColor);
            colourizeCommand.execute();
            this.gui.undoStack.push(colourizeCommand);
        }
        if(innerValid==true && outerValid==true){
            chosenColor = jColorChooser1.getColor();
            colourizeCommand = new ColourizeCommand(gui.engine,
                    gui.shapeComboBox,
                    gui.currentShape,
                    chosenColor,
                    chosenColor);
            colourizeCommand.execute();
            this.gui.undoStack.push(colourizeCommand);
        }
        this.gui.UndoButton.setEnabled(true);
        this.gui.engine.refresh(this.gui.panel4.getGraphics());
        dispose();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       innerValid = !innerValid;
    }
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        outerValid = !outerValid;
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
}
