package GUI;
import Engine.DrawingEngine;
import Patterns.*;
import ResizeShapes.*;
import ShapeWindows.*;
import Shapes.*;
import Shapes.Shape;
import UtilWindows.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;


public class Gui extends JFrame implements ActionListener  {

    //public variables to be passed to the windows
    public DrawingEngine engine ;
    public Shape currentShape;
    public  Panel4 panel4;
    public Stack<Command> undoStack = new Stack<>();
    public Stack<Command> redoStack = new Stack<>();

    //panel 1 variables
    public JButton UndoButton;
    public JButton RedoButton;
    public JComboBox<Shape> shapeComboBox;
    private final JButton resetButton;
    private final JButton saveButton;
    private final JButton loadButton;


    //panel 2 variables
    private final JButton moveButton;
    private final JButton resizeButton;
    private final JButton colorizeButton;
    private final JButton deleteButton;


    //panel 3 buttons
    private final JButton circleButton;
    private final JButton squareButton;
    private final JButton rectangleButton;
    private final JButton lineSegmentButton;



    public Gui() {
        engine = new DrawingEngine();
        JFrame frame = new JFrame("Paint Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1094, 827));
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 800));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(150, 300));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        shapeComboBox = new JComboBox<>();
        SelectedShape selectedShape = new SelectedShape();
        shapeComboBox.addItem(selectedShape);
        shapeComboBox.addActionListener(this);

        UndoButton = new JButton("Undo");
        UndoButton.addActionListener(this);
        UndoButton.setFocusable(false);
        UndoButton.setPreferredSize(new Dimension(100, 30));

        RedoButton = new JButton("Redo");
        RedoButton.addActionListener(this);
        RedoButton.setFocusable(false);
        RedoButton.setPreferredSize(new Dimension(100, 30));

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setToolTipText("Reset Cannot be undone");
        resetButton.setPreferredSize(new Dimension(100, 30));

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setFocusable(false);
        saveButton.setPreferredSize(new Dimension(100, 30));

        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        loadButton.setFocusable(false);
        loadButton.setPreferredSize(new Dimension(100, 30));

        panel1.add(UndoButton);
        panel1.add(RedoButton);
        panel1.add(resetButton);
        panel1.add(saveButton);
        panel1.add(loadButton);


        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(150, 600));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        colorizeButton = new JButton("Colorize");
        colorizeButton.addActionListener(this);
        colorizeButton.setFocusable(false);
        colorizeButton.setPreferredSize(new Dimension(100, 30));

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setFocusable(false);
        deleteButton.setPreferredSize(new Dimension(100, 30));



        resizeButton = new JButton("Resize");
        resizeButton.addActionListener(this);
        resizeButton.setFocusable(false);
        resizeButton.setPreferredSize(new Dimension(100, 30));

        moveButton = new JButton("Move");
        moveButton.addActionListener(this);
        moveButton.setFocusable(false);
        moveButton.setPreferredSize(new Dimension(100, 30));

        panel2.add(shapeComboBox);
        panel2.add(colorizeButton);
        panel2.add(deleteButton);
        panel2.add(resizeButton);
        panel2.add(moveButton);

        panel.add(panel1);
        panel.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT,80,25));
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
        if (e.getSource() == deleteButton)
        {
            if (currentShape == null || currentShape.toString().equals("Select a Shape")) {
                JOptionPane.showMessageDialog(null, "Please select a valid shape", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            DeleteCommand deleteCommand = new DeleteCommand(engine,shapeComboBox, currentShape,panel4);
            deleteCommand.execute();
            undoStack.push(deleteCommand);
        }
        if (e.getSource()==resetButton)
        {
           ResetCommand resetCommand = new ResetCommand(this);
           resetCommand.execute();
           undoStack.push(resetCommand);
       }
        if (e.getSource()==resizeButton)
        {
            if (currentShape == null || currentShape.toString().equals("Select a Shape")) {
                JOptionPane.showMessageDialog(null, "Please select a valid shape", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

           if (currentShape.type().equals("Rectangle")) {
               new RectangleResizeWindow(this);
           }
           if (currentShape.type().equals("Circle")) {
               new CircleResizeWindow(this);
           }
           if (currentShape.type().equals("Segment")) {
               new LineSegmentResizeWindow(this);
           }
           if (currentShape.type().equals("Square")) {
               new SquareResizeWindow(this);
           }
        }
        if(e.getSource()==moveButton)
        {
            if (currentShape == null || currentShape.toString().equals("Select a Shape")) {
                JOptionPane.showMessageDialog(null, "Please select a valid shape", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (currentShape.type().equals("Segment")) {
                new MoveSegmentWindow(this);
            }
            else {
                new MoveWindow(this);
            }
        }
        if (e.getSource()==UndoButton)
        {
            if(!undoStack.isEmpty())
            {
                Command lastCommand = undoStack.pop();
                lastCommand.undo();
                this.panel4.repaint();
                this.redoStack.push(lastCommand);
            }
            else{
                JOptionPane.showMessageDialog(null, "Undo stack is empty");
            }
        }
        if (e.getSource()==RedoButton)
        {
            if (!redoStack.isEmpty())
            {
                Command lastCommand = redoStack.pop();
                lastCommand.execute();
                this.undoStack.push(lastCommand);
                this.panel4.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "Redo stack is empty");
            }
        }
        if (e.getSource()==shapeComboBox)
        {
            this.currentShape = (Shape) shapeComboBox.getSelectedItem();
        }
        if (e.getSource()==saveButton)
        {
             new GetFileLocation(this,true,false);
        }
        if (e.getSource()==loadButton)
        {
            new GetFileLocation(this, false, true);
        }
    }

    public static void main(String[] args) {
        new Gui();
    }
}
