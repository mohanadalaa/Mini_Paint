package ShapeWindows;

import GUI.Gui;
import Patterns.CreateCommand;
import Shapes.Rectangle;

import java.awt.*;
import javax.swing.*;


public class RectangleWindow extends javax.swing.JFrame {

    private final Gui gui;
    public RectangleWindow(Gui gui) {
        this.gui = gui;
        initComponents();
        this.setTitle("Rectangle Creation Window");
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
        JLabel jLabel4 = new JLabel();
        jTextField3 = new javax.swing.JTextField();
        JLabel jLabel5 = new JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Create");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jLabel1.setText("Enter coordinates");

        jLabel2.setText("X");

        jLabel3.setText("Y");

        jLabel4.setText("Length");

        jLabel5.setText("Width");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(94, 117, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(81, 81, 81))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel4)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        if(jTextField1.getText().isEmpty() ||
           jTextField2.getText().isEmpty() ||
           jTextField3.getText().isEmpty() ||
           jTextField4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Please enter coordinates and the Parameters",
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String coorX = jTextField2.getText();
        String coorY = jTextField1.getText();
        String length = jTextField4.getText();
        String width = jTextField3.getText();


        boolean validX;
        boolean validY;
        boolean validLength;
        boolean validWidth;

        int x=0;
        int y=0;
        double len=0;
        double w=0;

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
        try {
            len = Double.parseDouble(length);
            validLength = true;
        } catch (NumberFormatException e) {
            validLength = false;
        }
        try{
            w = Double.parseDouble(width);
            validWidth = true;
        }
        catch(NumberFormatException e){
            validWidth = false;
        }


        if (!(validX && validY && validLength&& validWidth)){
            JOptionPane.showMessageDialog(null,
                    "Please enter valid Coordinates , Length and Width",
                    "Error",JOptionPane.ERROR_MESSAGE);
            jTextField2.setText("");
            jTextField1.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            return;
        }
        if (x<0 || y<0  || len<=0||w<=0){
            JOptionPane.showMessageDialog(null,
                    "Please enter valid Coordinates , Length and Width",
                    "Error",JOptionPane.ERROR_MESSAGE);
            jTextField2.setText("");
            jTextField1.setText("");
            jTextField3.setText("");
            return;
        }

        Rectangle rectangle = new Rectangle(len,w,new Point(x,y));
        CreateCommand command = new CreateCommand(this.gui.engine,this.gui.shapeComboBox,rectangle);
        command.execute();
        this.gui.undoStack.push(command);

        this.gui.engine.refresh(this.gui.panel4.getGraphics());
        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
}
