import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;

public class Geometry extends Application {
    public static final int OFFSET = 30;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        Line line;
        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;

        for (int i = 0; i < 5; i++) {
            line = new Line(centerX + i * OFFSET, centerY + i * OFFSET, centerX + i * OFFSET, centerY - (i + 1) * OFFSET);
            line.setStroke(RED);
            group.getChildren().add(line);
        }

        for (int i = 0; i < 5; i++) {
            line = new Line(centerX + i * OFFSET, centerY + i * OFFSET, centerX - (i + 1) * OFFSET, centerY + i * OFFSET);
            line.setStroke(RED);
            group.getChildren().add(line);
        }

        for (int i = 1; i <= 5; i++) {
            line = new Line(centerX - i * OFFSET, centerY - (i + 1) * OFFSET,centerX - i * OFFSET, centerY + (i - 1) * OFFSET);
            line.setStroke(RED);
            group.getChildren().add(line);
        }

        for (int i = 1; i <= 5; i++) {
            line = new Line(centerX - i * OFFSET, centerY - (i + 1) * OFFSET, centerX + i * OFFSET, centerY - (i + 1) * OFFSET);
            line.setStroke(RED);
            group.getChildren().add(line);
        }

        // end TODO
        stage.setTitle("Draw square shaped spiral"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
