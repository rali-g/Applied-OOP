package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
// Abbreviaton key:       fx-drawing-main
// Template description: JavaFX App class for drawing
// Variables: CLASS_NAME must be assigned clipboard() expression
// 1. Create a Java class
// 2. Copy the class name in the Clipboard (^C)
// 3, Overwrite all  the class contents by running this Live template
// 4. Right-click the class name (should be the same as in the originally created class)
// 5. Select Show Content actions and execute Set package name to ...<your package name> 

public class JavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 250);

        for (int i = 0; i < 12; i++) {
            Circle circle = new Circle(scene.getWidth() / 2, scene.getHeight() / 2, 10 + i * 10);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            group.getChildren().add(circle);
        }

        Line line1 = new Line(scene.getWidth() / 2 - 10 * 12, scene.getHeight() / 2, scene.getWidth() / 2 + 10 * 12, scene.getHeight() / 2);
        Line line2 = new Line(scene.getWidth() / 2, scene.getHeight() / 2 - 10 * 12, scene.getWidth() / 2, scene.getHeight() / 2 + 10 * 12);
        line1.setStroke(Color.RED);
        line2.setStroke(Color.RED);
        group.getChildren().add(line1);
        group.getChildren().add(line2);

        stage.setTitle("Drawing scene"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
