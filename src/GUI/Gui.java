package GUI;

import Engine.DrawingEngine;
import Patterns.ColourizeCommand;
import Patterns.Command;
import Patterns.CreateCommand;
import Patterns.DeleteCommand;
import Shapes.*;
import Shapes.Rectangle;
import Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;


public class Gui extends JFrame implements ActionListener  {

    DrawingEngine engine ;
    JComboBox<Shape> shapeComboBox;
    JButton colorizeButton;
    JButton deleteButton;
    JButton resetButton;
    JButton UndoButton;
    JButton circleButton;
    JButton squareButton;
    JButton rectangleButton;
    Shape currentShape;
    Panel4 panel4;

    public Gui() {

        engine = new DrawingEngine();
        JFrame frame = new JFrame("Paint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
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
        panel2.setPreferredSize(new Dimension(150, 250));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        colorizeButton = new JButton("Colorize");
        colorizeButton.addActionListener(this);
        colorizeButton.setFocusable(false);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setFocusable(false);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

        UndoButton = new JButton("Undo");
        UndoButton.addActionListener(this);
        UndoButton.setFocusable(false);

        panel2.add(colorizeButton);
        panel2.add(deleteButton);
        panel2.add(resetButton);
        panel2.add(UndoButton);

        panel.add(panel1);
        panel.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT,60,25));
        circleButton = new JButton("Circle");
        circleButton.setFocusable(false);
        circleButton.addActionListener(this);

//        JButton lineSegmentButton = new JButton("Line Segment");
//        lineSegmentButton.setFocusable(false);
//        lineSegmentButton.addActionListener(this);

        squareButton = new JButton("Square");
        squareButton.setFocusable(false);
        squareButton.addActionListener(this);

        rectangleButton = new JButton("Rectangle");
        rectangleButton.setFocusable(false);
        rectangleButton.addActionListener(this);

        panel3.add(circleButton);
       // panel3.add(lineSegmentButton);
        panel3.add(squareButton);
        panel3.add(rectangleButton);

        panel4 = new Panel4(this.engine);
        panel4.setBackground(Color.WHITE);
        panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        frame.add(panel3, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    Stack<Command> undoStack = new Stack<>();

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==squareButton)
       {
           Square square = new Square(10,new Point(10,20));
           CreateCommand command = new CreateCommand(this.engine,this.shapeComboBox,square);
           command.execute();
           undoStack.push(command);
           this.engine.refresh(panel4.getGraphics());
       }
       if(e.getSource()==rectangleButton)
       {
           Rectangle rectangle = new Rectangle(100,200,new Point(200,20));
           CreateCommand command = new CreateCommand(this.engine,this.shapeComboBox,rectangle);
           command.execute();
           undoStack.push(command);
           this.engine.refresh(panel4.getGraphics());
       }
       if (e.getSource()==circleButton)
       {
            Circle circle = new Circle(100,new Point(100,100));
            CreateCommand command = new CreateCommand(this.engine,this.shapeComboBox,circle);
            command.execute();
            undoStack.push(command);
            this.engine.refresh(panel4.getGraphics());
       }
       if(e.getSource()==colorizeButton)
       {
           if (currentShape == null || currentShape.toString().equals("Select a Shape")) {
               JOptionPane.showMessageDialog(null, "Please select a valid shape", "Warning", JOptionPane.WARNING_MESSAGE);
               return;
           }
            ColorMenu colorChooserWindow = new ColorMenu(this);
            colorChooserWindow.setVisible(true);
            Color color = colorChooserWindow.getChosenColor();

            ColourizeCommand colourizeCommand = new ColourizeCommand(engine,shapeComboBox,currentShape,color);
            colourizeCommand.execute();
            undoStack.push(colourizeCommand);
            this.engine.refresh(panel4.getGraphics());
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
           return;
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
                JOptionPane.showMessageDialog(null,"Nothing to undo", "Warning", JOptionPane.WARNING_MESSAGE);
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
