package Engine;
import Shapes.Shape;
import java.util.ArrayList;

public class DrawingEngine implements Engine{

    //List of the shapes
    private final  ArrayList<Shape> list;

    //counter for the shapes
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
                shape.setIndex(Number_Of_Circles);
                Number_Of_Circles++;
                break;
            case "Rectangle":
                shape.setIndex(Number_Of_Rectangles);
                Number_Of_Rectangles++;
                break;
            case "Square":
                shape.setIndex(Number_Of_Squares);
                Number_Of_Squares++;
                break;
            case "Segment":
                shape.setIndex(Number_Of_Segments);
                Number_Of_Segments++;
                break;
        }
        this.list.add(shape);
    }

    //add shape at specific index used in undo deletion command
    public void addShape(Shape shape,int index) {
        switch (shape.type()) {
            case "Circle":
                shape.setIndex(Number_Of_Circles);
                Number_Of_Circles++;
                break;
            case "Rectangle":
                shape.setIndex(Number_Of_Rectangles);
                Number_Of_Rectangles++;
                break;
            case "Square":
                shape.setIndex(Number_Of_Squares);
                Number_Of_Squares++;
                break;
            case "Segment":
                shape.setIndex(Number_Of_Segments);
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
    //to keep the list well indexed
    private void reindexShapes(String type) {
        int currentIndex = 0;
        for (Shape s : this.list) {
            if (s.type().equals(type)) {
                s.setIndex(currentIndex);
                currentIndex++;
            }
        }
    }
    //clear the list and reset the counters
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
