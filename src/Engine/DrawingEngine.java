package Engine;
import Shapes.Shape;
import java.util.ArrayList;

public class DrawingEngine implements Engine{

    private  ArrayList<Shape> list;

    private int Number_Of_Circles=0;
    private int Number_Of_Rectangles=0;
    private int Number_Of_Squares=0;
    private int Number_Of_Segments=0;



    public DrawingEngine(){
        this.list=new ArrayList<>();
    }

    @Override
    public void addShape(Shape shape) {
        switch (shape.type()) {
            case "Circle":
                shape.setIndx(Number_Of_Circles);
                Number_Of_Circles++;
                break;
            case "Rectangle":
                shape.setIndx(Number_Of_Rectangles);
                Number_Of_Rectangles++;
                break;
            case "Square":
                shape.setIndx(Number_Of_Squares);
                Number_Of_Squares++;
                break;
            case "Segment":
                shape.setIndx(Number_Of_Segments);
                Number_Of_Segments++;
                break;
        }
        this.list.add(shape);
    }

    public void addShape(Shape shape,int index) {
        switch (shape.type()) {
            case "Circle":
                shape.setIndx(Number_Of_Circles);
                Number_Of_Circles++;
                break;
            case "Rectangle":
                shape.setIndx(Number_Of_Rectangles);
                Number_Of_Rectangles++;
                break;
            case "Square":
                shape.setIndx(Number_Of_Squares);
                Number_Of_Squares++;
                break;
            case "Segment":
                shape.setIndx(Number_Of_Segments);
                Number_Of_Segments++;
                break;
        }
        this.list.add(index, shape);
    }
    @Override
    public void removeShape(Shape shape) {
           this.list.remove(shape) ;

            switch (shape.type()) {
                case "Circle":
                    Number_Of_Circles--;
                    reindexShapes("Circle");
                    break;
                case "Rectangle":
                    Number_Of_Rectangles--;
                    reindexShapes("Rectangle");
                    break;
                case "Square":
                    Number_Of_Squares--;
                    reindexShapes("Square");
                    break;
                case "Segment":
                    Number_Of_Segments--;
                    reindexShapes("Segment");
                    break;
            }

    }
    private void reindexShapes(String type) {
        int currentIndex = 0; // Start reindexing from 0
        for (Shape s : this.list) {
            if (s.type().equals(type)) {
                s.setIndx(currentIndex); // Update the index for shapes of the given type
                currentIndex++; // Increment the index
            }
        }
    }
    public void clearTheList()
    {
        Number_Of_Circles=0;
        Number_Of_Rectangles=0;
        Number_Of_Squares=0;
        Number_Of_Segments=0;
        this.list.clear();
    }

    @Override
    public ArrayList<Shape> getShapes() {
        return this.list;
    }

    @Override
    public void refresh(java.awt.Graphics canvas ) {
        for(Shape shape : this.list){
            shape.draw(canvas);
        }
    }
}
