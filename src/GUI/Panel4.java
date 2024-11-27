package GUI;
import Engine.DrawingEngine;
import javax.swing.*;
import java.awt.*;

public class Panel4 extends JPanel {
    private final DrawingEngine engine;

    public Panel4(DrawingEngine engine) {
        this.engine = engine;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        engine.refresh(g);
    }
}
