package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class GameApplication extends javafx.application.Application {

    @Override
    public void start(javafx.stage.Stage stage) throws Exception {
        javafx.scene.Parent root
                = javafx.fxml.FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));

        javafx.scene.Scene scene = new javafx.scene.Scene(root);

        // Set the Window title
        stage.setTitle("gameScene");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
