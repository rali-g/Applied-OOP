package pr1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GCDController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnQuit;

    @FXML
    private Label lblA;

    @FXML
    private Label lblB;

    @FXML
    private Label lblGCD;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtGCD;

    @FXML
    void btnComputeOnClick(ActionEvent event) {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());

        txtGCD.setText(String.format("%d", gcd(a, b)));
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnCompute != null : "fx:id=\"btnCompute\" was not injected: check your FXML file 'gcd-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'gcd-view.fxml'.";
        assert lblA != null : "fx:id=\"lblA\" was not injected: check your FXML file 'gcd-view.fxml'.";
        assert lblB != null : "fx:id=\"lblB\" was not injected: check your FXML file 'gcd-view.fxml'.";
        assert lblGCD != null : "fx:id=\"lblGCD\" was not injected: check your FXML file 'gcd-view.fxml'.";
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'gcd-view.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'gcd-view.fxml'.";
        assert txtGCD != null : "fx:id=\"txtGCD\" was not injected: check your FXML file 'gcd-view.fxml'.";

    }

}

