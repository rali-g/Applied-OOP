import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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

public class Geometry extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        double width = scene.getWidth();
        double height = scene.getHeight();
        double partH = height / 20;
        double partW = width / 20;

        for(int i = 0; i < 20; i++)
        {
            Line line = new Line(0, i * partH, width - i * partW, 0);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
        }

        for(int i = 0; i < 20; i++)
        {
            Line line = new Line(0, height - i * partH, width - i * partW, height);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
        }

        for(int i = 0; i < 20; i++)
        {
            Line line = new Line(width, height - i * partH, partW * i, height);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
        }

        for(int i = 0; i < 20; i++)
        {
            Line line = new Line(width, partH * i, partW * i, 0);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
        }

//        for (int i = 0; i < 20; i++) {//left
//            Line line = new Line(partW, partH, partW, partH);
//            group.getChildren().add(line);
//        }

        // end TODO
        stage.setTitle("Canvas demo"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
