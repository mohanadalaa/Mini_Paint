package GUI;
import Engine.DrawingEngine;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private DrawingEngine engine;
    public Canvas(DrawingEngine engine) {
        this.engine = engine;
        setBackground(Color.WHITE);
    }
    public void paint(java.awt.Graphics canvas) {
        super.paint(canvas);
        engine.refresh(canvas);
    }
}
