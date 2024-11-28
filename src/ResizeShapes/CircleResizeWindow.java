package ResizeShapes;

import GUI.Gui;
import Patterns.ResizeCommand;

import javax.swing.*;

public class CircleResizeWindow extends javax.swing.JFrame {
    private final Gui gui;

    public CircleResizeWindow(Gui gui) {
        this.gui = gui;
        initComponents();
        this.setTitle("Circle Resize Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        jTextField1 = new javax.swing.JTextField();
        JButton jButton1 = new JButton();

        jLabel1.setText("Radius");

        jButton1.setText("Resize");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(82, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jButton1)))
                                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(73, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a valid Radius ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String strRadius = jTextField1.getText();

        boolean validRadius;
        int radius = 0;

        try {
            radius = Integer.parseInt(strRadius);
            validRadius = true;
        } catch (NumberFormatException e) {
            validRadius = false;
        }

        if (!validRadius || radius < 0) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a valid  Radius",
                    "Error", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText("");
            return;
        }

        // Execute Resize Command
        ResizeCommand command = new ResizeCommand(this.gui.shapeComboBox, this.gui.currentShape, radius);
        command.execute();
        this.gui.undoStack.push(command);
        this.gui.panel4.repaint();
        this.dispose();
    }

    private javax.swing.JTextField jTextField1;
}
