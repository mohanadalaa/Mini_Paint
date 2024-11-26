package ResizeShapes;

import GUI.Gui;
import Patterns.MoveCommand;
import Patterns.ResizeCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LineSegmentResizeWindow extends javax.swing.JFrame {
    private Gui gui;

    public LineSegmentResizeWindow(Gui gui) {
        this.gui = gui;
        initComponents();
        this.setTitle("Line Segment Resize Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jButton1.setFocusable(false);
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        endY = new javax.swing.JTextField();
        endX = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Resize");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel4.setText("End Point");

        jLabel2.setText("X");

        jLabel3.setText("Y");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(102, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(endX, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(endY, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(endX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        if (endX.getText().isEmpty() || endY.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please enter End Point Coordinates",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String xEnd = endX.getText();
        String yEnd = endY.getText();

        boolean validX;
        boolean validY;

        int xe = 0;
        int ye = 0;

        try {
            xe = Integer.parseInt(xEnd);
            validX = true;
        } catch (NumberFormatException e) {
            validX = false;
        }
        try {
            ye = Integer.parseInt(yEnd);
            validY = true;
        } catch (NumberFormatException e) {
            validY = false;
        }

        if (!(validX && validY)) {
            JOptionPane.showMessageDialog(null,
                    "Please enter valid End Point Coordinates",
                    "Error", JOptionPane.ERROR_MESSAGE);
            endX.setText("");
            endY.setText("");
            return;
        }

        if (xe < 0 || ye < 0) {
            JOptionPane.showMessageDialog(null,
                    "Coordinates must be non-negative",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Point endPoint = new Point(xe, ye);

        ResizeCommand command = new ResizeCommand(this.gui.shapeComboBox, this.gui.currentShape,endPoint);
        command.execute();
        this.gui.undoStack.push(command);
        this.gui.UndoButton.setEnabled(true);
        this.gui.panel4.repaint();
        this.dispose();
    }

    private javax.swing.JTextField endX;
    private javax.swing.JTextField endY;
    private javax.swing.JButton jButton1;
}
