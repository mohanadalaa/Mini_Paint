package UtilWindows;
import GUI.Gui;
import Patterns.MoveCommand;
import javax.swing.*;
import java.awt.*;

public class MoveWindow extends javax.swing.JFrame {
    private final Gui gui;

    public MoveWindow(Gui gui) {
        this.gui = gui;
        initComponents();
        this.setTitle("Move "+this.gui.currentShape.toString()+" Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jButton1.setFocusable(false);
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Create");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel1.setText("Enter coordinates");
        jLabel2.setText("X");
        jLabel3.setText("Y");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(94, 128, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(81, 81, 81))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(31, 31, 31)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(jTextField1.getText().isEmpty() ||
                jTextField2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "Please enter coordinates and the Parameters",
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String coorX = jTextField2.getText();
        String coorY = jTextField1.getText();

        boolean validX;
        boolean validY;

        int x=0;
        int y=0;

        try {
            x=Integer.parseInt(coorX);
            validX = true;
        } catch (NumberFormatException e) {
            validX = false;
        }
        try {
            y= Integer.parseInt(coorY);
            validY = true;
        } catch (NumberFormatException e) {
            validY = false;
        }

        if (!(validX && validY )){
            JOptionPane.showMessageDialog(null,
                    "Please enter valid Coordinates and Side Length",
                    "Error",JOptionPane.ERROR_MESSAGE);
            jTextField2.setText("");
            jTextField1.setText("");
            return;
        }
        if (x<0 || y<0){
            JOptionPane.showMessageDialog(null,
                    "Please enter valid Coordinates",
                    "Error",JOptionPane.ERROR_MESSAGE);
            jTextField2.setText("");
            jTextField1.setText("");
            return;
        }
        MoveCommand command = new MoveCommand(this.gui.shapeComboBox, this.gui.currentShape,new Point(x,y),null);
        command.execute();
        this.gui.undoStack.push(command);
        this.gui.panel4.repaint();
        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}
