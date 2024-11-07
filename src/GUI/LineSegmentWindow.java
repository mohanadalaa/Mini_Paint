
package GUI;

import Patterns.CreateCommand;
import Shapes.LineSegment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LineSegmentWindow extends javax.swing.JFrame {
    private Gui gui;
    public LineSegmentWindow(Gui gui) {
        this.gui=gui;
        initComponents();
        this.setTitle("LineSegment Creation Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jButton1.setFocusable(false);
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        startY = new javax.swing.JTextField();
        startX = new javax.swing.JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        endY = new javax.swing.JTextField();
        endX = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Create");
        jButton1.addActionListener(this::jButton1ActionPerformed);


        jLabel1.setText("Start Point");

        jLabel2.setText("X");

        jLabel3.setText("Y");

        jLabel4.setText("End Point");


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
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(endX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(startX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startY, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(endY, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(startY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
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
        if(startX.getText().isEmpty() ||
                startY.getText().isEmpty() ||
                endX.getText().isEmpty() ||
                endY.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please enter Coordinates",
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String xStart = startX.getText();
        String yStart = startY.getText();
        String xEnd = endX.getText();
        String yEnd = endY.getText();

        boolean valid1;
        boolean valid2;
        boolean valid3;
        boolean valid4;

        int xs=0;
        int ys=0;
        int xe=0;
        int ye=0;

        try {
            xs=Integer.parseInt(xStart);
            valid1 = true;
        } catch (NumberFormatException e) {
            valid1 = false;
        }
        try {
            ys= Integer.parseInt(yStart);
            valid2 = true;
        } catch (NumberFormatException e) {
            valid2 = false;
        }
        try {
            xe = Integer.parseInt(xEnd);
            valid3 = true;
        } catch (NumberFormatException e) {
            valid3 = false;
        }
        try{
            ye = Integer.parseInt(yEnd);
            valid4 = true;
        }
        catch(NumberFormatException e){
            valid4 = false;
        }
        if(!(valid1 && valid2 && valid3 && valid4)){
            JOptionPane.showMessageDialog(null,
                    "Please enter valid Coordinates , Length and Width",
                    "Error",JOptionPane.ERROR_MESSAGE);
            startX.setText("");
            startY.setText("");
            endX.setText("");
            endY.setText("");
            return;
        }

        LineSegment segment = new LineSegment(new Point(xs,ys),new Point(xe,ye));
        CreateCommand command = new CreateCommand(this.gui.engine,this.gui.shapeComboBox,segment);
        command.execute();
        this.gui.undoStack.push(command);
        this.gui.engine.refresh(this.gui.panel4.getGraphics());
        this.dispose();

    }



    private javax.swing.JTextField endX;
    private javax.swing.JTextField endY;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField startX;
    private javax.swing.JTextField startY;
}

