package geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Line {
    private Point sPoint;
    private Point ePoint;

    public Line(){
        this(new Point(), new Point(new double[]{1, 1}));
    }
    public Line(Point sPoint, Point ePoint) {
        setEPoint(ePoint);
        setSPoint(sPoint);
    }

    private void setSPoint(Point sPoint) {
        if(sPoint == null){
            this.sPoint = new Point();
        }else{
            this.sPoint = new Point(sPoint);
        }
    }

    private void setEPoint(Point ePoint) {
        if(ePoint == null){
            this.ePoint = new Point(new double[]{1, 1});
        }else{
            this.ePoint = new Point(ePoint);
        }
    }

    public Line(Line l){
        this(l.getSPoint(), l.getEPoint());
    }

    public Point getSPoint() {
        return new Point(sPoint);
    }

    public Point getEPoint() {
        return new Point(ePoint);
    }

    public void draw(Group pane){
        javafx.scene.shape.Line line = new javafx.scene.shape.Line(
                sPoint.getCoords()[0], sPoint.getCoords()[1],
                ePoint.getCoords()[0], ePoint.getCoords()[1]
        );
        line.setStroke(Color.BLACK);
        pane.getChildren().add(line);
    }

    @Override
    public String toString() {
        return String.format("Starting point: %s," + "Ending point: %s",
                sPoint.toString(), ePoint.toString());
    }
}
