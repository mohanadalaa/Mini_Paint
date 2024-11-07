package GUI;

import Patterns.ColourizeCommand;

import java.awt.*;
import javax.swing.*;

public class ColorWindow extends JDialog {
    private Color chosenColor;
    private Gui gui;
    javax.swing.JColorChooser jColorChooser1;
    public ColorWindow(Gui gui) {
        super(gui, true);
        this.gui = gui;
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JButton  jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Cancel");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jButton1)
                                .addGap(72, 72, 72)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        chosenColor = jColorChooser1.getColor();
        ColourizeCommand colourizeCommand =
                new ColourizeCommand(
                        this.gui.engine,
                        this.gui.shapeComboBox,
                        this.gui.currentShape,
                        chosenColor);
        colourizeCommand.execute();
        this.gui.undoStack.push(colourizeCommand);
        this.gui.engine.refresh(this.gui.panel4.getGraphics());
        setVisible(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        chosenColor = null;
        setVisible(false);
    }
    public Color getChosenColor() {
        return chosenColor;
    }
}
