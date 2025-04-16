package test;

import geometry.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;
// Abbreviaton key:       fx-drawing-main
// Template description: JavaFX App class for drawing
// Variables: CLASS_NAME must be assigned clipboard() expression
// 1. Create a Java class
// 2. Copy the class name in the Clipboard (^C)
// 3, Overwrite all  the class contents by running this Live template
// 4. Right-click the class name (should be the same as in the originally created class)
// 5. Select Show Content actions and execute Set package name to ...<your package name>

public class GeometryTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void drawRectangleWithDiagonals(Group group, Point uPoint, double width, double height) {
        Rectangle rectangle = new Rectangle(uPoint, width, height);
        rectangle.draw(group);

        double[] uPointCoords = uPoint.getCoords();
        Line diagonal1 = new Line(uPoint, new Point(new double[]{
                uPointCoords[0] + width, uPointCoords[1] + height
        }));

        Line diagonal2 = new Line(new Point(new double[]{
                uPointCoords[0] + width, uPointCoords[1]}),
                new Point(new double[]{uPointCoords[0], uPointCoords[1] + height
        }));

        diagonal1.draw(group);
        diagonal2.draw(group);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 600);

        // TODO  Type code for Java FX drawing objects

        Random generator = new Random();
        Point uPoint1 = new Point(new double[]{
                generator.nextDouble(500),
                generator.nextDouble(500)
        });

        Point uPoint2 = new Point(new double[]{
                generator.nextDouble(500),
                generator.nextDouble(500)
        });
        double width1 = generator.nextDouble(20, 100);
        double height1 = generator.nextDouble(20, 100);
        double width2 = generator.nextDouble(20, 100);
        double height2 = generator.nextDouble(20, 100);

        drawRectangleWithDiagonals(group, uPoint1, width1, height1);
        drawRectangleWithDiagonals(group, uPoint2, width2, height2);

        // end TODO
        stage.setTitle("Geometry"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
