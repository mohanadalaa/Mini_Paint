package Patterns;

import GUI.Panel4;
import Shapes.Shape;

public interface Command {
    void execute();
    void undo();
}
