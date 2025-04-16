package geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Rectangle {
    private Point uPoint;
    private double width;
    private double height;

    public Rectangle(){
        this(new Point(), 1, 1);
    }

    public Rectangle(Point uPoint, double width, double height){
        setuPoint(uPoint);
        setWidth(width);
        setHeight(height);
    }

    private void setHeight(double height) {
        if(height > 0){
            this.height = height;
        }else{
            this.height = 1;
        }
    }

    private void setWidth(double width) {
        if(width > 0){
            this.width = width;
        }else{
            this.width = 1;
        }
    }

    private void setuPoint(Point uPoint) {
        if(uPoint == null){
            this.uPoint = new Point();
        }else{
            this.uPoint = new Point(uPoint);
        }
    }

    public Rectangle(Rectangle r){
        this(r.getuPoint(), r.getWidth(), r.getHeight());
    }

    private double getHeight() {
        return height;
    }

    private double getWidth() {
        return width;
    }

    private Point getuPoint() {
        return new Point(uPoint);
    }

    public void draw(Group pane){
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(
                uPoint.getCoords()[0], uPoint.getCoords()[1], width, height
        );
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        pane.getChildren().add(rectangle);
    }

    @Override
    public String toString(){
        return String.format("Upper left corner coords: %s%n" +
                "width:  %.2f, height: %.2f", uPoint.toString(), width, height);
    }
}
