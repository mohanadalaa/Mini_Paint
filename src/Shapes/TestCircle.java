package Shapes;

import javax.swing.*;
import java.awt.*;

public class TestCircle extends JPanel {
    private Circle circle;

    public TestCircle() {
        circle = new Circle(100, new Point(180, 180));
        circle.setColor(Color.RED);
        circle.setFillColor(Color.RED);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        circle.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Circle");
        TestCircle panel = new TestCircle();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
