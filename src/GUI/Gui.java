package GUI;

import Engine.DrawingEngine;
import Patterns.Command;
import Patterns.DeleteCommand;
import Shapes.*;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;


public class Gui extends JFrame implements ActionListener  {

    protected DrawingEngine engine ;
    protected JComboBox<Shape> shapeComboBox;
    protected JButton colorizeButton;
    protected JButton deleteButton;
    protected JButton resetButton;
    protected JButton UndoButton;
    protected JButton circleButton;
    protected JButton squareButton;
    protected JButton rectangleButton;
    protected JButton lineSegmentButton;
    protected Shape currentShape;
    protected  Panel4 panel4;
    protected Stack<Command> undoStack = new Stack<>();

    public Gui() {

        engine = new DrawingEngine();
        JFrame frame = new JFrame("Paint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1094, 827));
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 500));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(150, 200));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        JLabel selectShapeLabel = new JLabel("Select Shape");
        shapeComboBox = new JComboBox<>();
        SelectedShape selectedShape = new SelectedShape();
        shapeComboBox.addItem(selectedShape);
        shapeComboBox.addActionListener(this);

        panel1.add(selectShapeLabel);
        panel1.add(shapeComboBox);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(150, 800));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,70));
        colorizeButton = new JButton("Colorize");
        colorizeButton.addActionListener(this);
        colorizeButton.setFocusable(false);
        colorizeButton.setPreferredSize(new Dimension(100, 30));

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setFocusable(false);
        deleteButton.setPreferredSize(new Dimension(100, 30));

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setToolTipText("Reset Cannot be undone");
        resetButton.setPreferredSize(new Dimension(100, 30));

        UndoButton = new JButton("Undo");
        UndoButton.addActionListener(this);
        UndoButton.setFocusable(false);
        UndoButton.setPreferredSize(new Dimension(100, 30));

        panel2.add(colorizeButton);
        panel2.add(deleteButton);
        panel2.add(resetButton);
        panel2.add(UndoButton);

        panel.add(panel1);
        panel.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT,150,25));
        circleButton = new JButton("Circle");
        circleButton.setFocusable(false);
        circleButton.addActionListener(this);
        circleButton.setPreferredSize(new Dimension(150, 30));

        lineSegmentButton = new JButton("Line Segment");
        lineSegmentButton.setFocusable(false);
        lineSegmentButton.addActionListener(this);
        lineSegmentButton.setPreferredSize(new Dimension(150, 30));

        squareButton = new JButton("Square");
        squareButton.setFocusable(false);
        squareButton.addActionListener(this);
        squareButton.setPreferredSize(new Dimension(150, 30));

        rectangleButton = new JButton("Rectangle");
        rectangleButton.setFocusable(false);
        rectangleButton.addActionListener(this);
        rectangleButton.setPreferredSize(new Dimension(150, 30));

        panel3.add(circleButton);
        panel3.add(lineSegmentButton);
        panel3.add(squareButton);
        panel3.add(rectangleButton);

        panel4 = new Panel4(this.engine);
        panel4.setBackground(Color.WHITE);
        panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        frame.add(panel3, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.CENTER);

        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(30,10));
        frame.add( panel5,BorderLayout.EAST);

        JPanel panel6 = new JPanel();
        frame.add(panel6, BorderLayout.SOUTH);

        panel4.setPreferredSize(new Dimension(1600, 900));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        System.out.println(panel4.getWidth());
        System.out.println(panel4.getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==squareButton)
       {
             new SquareWindow(this);
       }
       if(e.getSource()==rectangleButton)
       {
           new RectangleWindow(this);
       }
       if (e.getSource()==circleButton)
       {
            new CircleWindow(this);
       }
       if(e.getSource()==lineSegmentButton)
       {
           new LineSegmentWindow(this);
       }
       if(e.getSource()==colorizeButton)
       {
           if (currentShape == null || currentShape.toString().equals("Select a Shape")) {
               JOptionPane.showMessageDialog(null, "Please select a valid shape", "Warning", JOptionPane.WARNING_MESSAGE);
               return;
           }
          new ColorWindow(this);
       }
        if (e.getSource() == deleteButton) {
            if (currentShape == null || currentShape.toString().equals("Select a Shape")) {
                JOptionPane.showMessageDialog(null, "Please select a valid shape", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            DeleteCommand deleteCommand = new DeleteCommand(engine,shapeComboBox,currentShape);
            deleteCommand.execute();
            undoStack.push(deleteCommand);
            panel4.repaint();
        }
        if (e.getSource()==resetButton)
       {
           this.engine.getShapes().clear();
           this.shapeComboBox.removeAllItems();
           this.shapeComboBox.addItem(new SelectedShape());
           shapeComboBox.setSelectedIndex(shapeComboBox.getItemCount()-1);
           panel4.repaint();
       }
        if (e.getSource()==UndoButton)
        {
            if(!undoStack.isEmpty())
            {
                Command lastCommand = undoStack.pop();
                lastCommand.undo();
                this.panel4.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null,"Nothing to Undo", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource()==shapeComboBox)
        {
            this.currentShape= (Shape) shapeComboBox.getSelectedItem();
        }
    }

    public static void main(String[] args) {
        new Gui();
    }
}
