package GUI;

import Engine.DrawingEngine;
import Shapes.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniPaintApp extends JFrame {
    private Canvas canvas;
    private DrawingEngine engine;
    private JComboBox<String> shapeSelector;

    public MiniPaintApp() {
        setTitle("Paint App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.engine = new DrawingEngine();
        this.canvas = new Canvas(engine);
        this.shapeSelector = new JComboBox<>();

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton circleButton = new JButton("Circle");

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double radius = Double.parseDouble(JOptionPane.showInputDialog("Enter radius:"));
                Point position = new Point(100, 100); // Example position
                Circle circle = new Circle(radius, position);
                engine.addShape(circle);
                shapeSelector.addItem("Circle" + engine.getShapes().size());
                canvas.repaint();
            }
        });

        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double width = Double.parseDouble(JOptionPane.showInputDialog("Enter width:"));
                double height = Double.parseDouble(JOptionPane.showInputDialog("Enter height:"));
                Point position = new Point(150, 150); // Example position
                Shapes.Rectangle rectangle = new Shapes.Rectangle(height,width,position);
                engine.addShape(rectangle);
                shapeSelector.addItem("Rectangle" + engine.getShapes().size());
                canvas.repaint();
            }
        });

        // Add more buttons for Square and LineSegment...

        JButton colorButton = new JButton("Colorize");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedShapeName = (String) shapeSelector.getSelectedItem();
                Shape selectedShape = (Shape) engine.getShapes().get(shapeSelector.getSelectedIndex());
                Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
               // selectedShape.setColor(newColor);
                canvas.repaint();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = shapeSelector.getSelectedIndex();
                if (selectedIndex >= 0) {
                    engine.removeShape(engine.getShapes().get(selectedIndex));
                    shapeSelector.removeItemAt(selectedIndex);
                    canvas.repaint();
                }
            }
        });

        controlPanel.add(circleButton);
        controlPanel.add(rectangleButton);
        // Add other shape buttons to controlPanel...
        controlPanel.add(shapeSelector);
        controlPanel.add(colorButton);
        controlPanel.add(deleteButton);

        add(controlPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
            MiniPaintApp app = new MiniPaintApp();
            app.setVisible(true);
    }
}
