package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;
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
        Scene scene = new Scene(group, 300, 250);
        double width = scene.getWidth();
        double height = scene.getHeight();
        double radius = 1 / 3.0 * Math.min(width, height);
        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLUE);
        group.getChildren().add(circle);

        double x = getLineX(width);
        Line line1 = new Line(x, 0, x, scene.getHeight());
        line1.setStroke(Color.RED);
        group.getChildren().add(line1);

        double chSquared = radius * radius - (centerX - x) * (centerX - x);
        if (chSquared >= 0) {
            double intersectionOneY = centerY + Math.sqrt(chSquared);
            drawIntersection(x, intersectionOneY, group);
            if (chSquared > 0) {
                double intersectionTwoY = centerY - Math.sqrt(chSquared);
                drawIntersection(x, intersectionTwoY, group);
            }
        } else {
            displayWarningDialog();
            Platform.exit();
            return;
        }

        stage.setTitle("Drawing scene"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    private double getLineX(double width) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter x:");

        double lineX;
        do {
            dialog.getEditor().clear();
            lineX = Double.parseDouble(dialog.showAndWait().get());
            if(lineX < 0 || lineX > width) {
                displayErrorDialog(width);
            }
        }
        while(lineX < 0 || lineX > width);

        return lineX;
    }

    private void drawIntersection(double x, double y, Group group) {
        Circle circle = new Circle(x, y, 3);
        group.getChildren().add(circle);
        Text text = new Text(x + 10, y, String.format("%.2f; %.2f", x, y));
        group.getChildren().add(text);
    }

    private void displayWarningDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("There are no intersection points");
        alert.showAndWait();
    }
    private void displayErrorDialog(double width){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(String.format("x must be in interval : [0; %.2f]", width));
        alert.showAndWait();
    }
}
