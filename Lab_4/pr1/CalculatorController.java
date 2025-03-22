package pr1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    private double memory;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddition;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnEquals;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnMemory;

    @FXML
    private Button btnMemoryAdd;

    @FXML
    private Button btnMemoryClear;

    @FXML
    private Button btnMemorySubtract;

    @FXML
    private Button btnMultiplication;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnOff;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSubtract;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnTwoZeros;

    @FXML
    private Button btnZero;

    @FXML
    private TextField txtResult;

    @FXML
    void btnAdditionOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            return;
        }
        memory += Double.parseDouble(text);
        txtResult.setText("");
    }

    @FXML
    void btnClearAllOnCLick(ActionEvent event) {
        txtResult.clear();
        txtResult.setText("0");
    }

    @FXML
    void btnClearOnCLick(ActionEvent event) {
        String text = txtResult.getText();
        if (text.equals("0")) {
            return;
        }
        txtResult.setText(text.substring(0, text.length() - 1));
        if(txtResult.getText().isEmpty()){
            txtResult.setText("0");
        }
    }

    @FXML
    void btnDivideOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            return;
        }
        memory = memory / Double.parseDouble(text);
        txtResult.setText("");
    }

    @FXML
    void btnDotOnClick(ActionEvent event) {

    }

    @FXML
    void btnEightOnAction(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("8");
        }else{
            txtResult.setText(text + "8");
        }
    }

    @FXML
    void btnEqualsOnCLick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            return;
        }
        memory += Double.parseDouble(text);
        txtResult.setText(Double.toString(memory));
    }

    @FXML
    void btnFiveOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("5");
        }else{
            txtResult.setText(text + "5");
        }
    }

    @FXML
    void btnFourOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("4");
        }else{
            txtResult.setText(text + "4");
        }
    }

    @FXML
    void btnMemoryAddOnCLick(ActionEvent event) {
        memory += Double.parseDouble(txtResult.getText());
    }

    @FXML
    void btnMemoryClearOnClick(ActionEvent event) {
        memory = 0;
    }

    @FXML
    void btnMemoryOnClick(ActionEvent event) {
        txtResult.setText(String.valueOf(memory));
    }

    @FXML
    void btnMemorySubtractOnCLick(ActionEvent event) {
        memory -= Double.parseDouble(txtResult.getText());
    }

    @FXML
    void btnMultiplicationOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            return;
        }
        memory *= Double.parseDouble(text);
        txtResult.setText("");
    }

    @FXML
    void btnNineOnAction(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("9");
        }else{
            txtResult.setText(text + "9");
        }
    }

    @FXML
    void btnOffOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnOneOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("1");
        }else{
            txtResult.setText(text + "1");
        }
    }

    @FXML
    void btnSevenOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("7");
        }else{
            txtResult.setText(text + "7");
        }
    }

    @FXML
    void btnSixOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("6");
        }else{
            txtResult.setText(text + "6");
        }
    }

    @FXML
    void btnSubtractOnCLick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            return;
        }
        memory -= Double.parseDouble(text);
        txtResult.setText("");
    }

    @FXML
    void btnThreeOnClick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("3");
        }else{
            txtResult.setText(text + "3");
        }
    }

    @FXML
    void btnTwoOnCLick(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            txtResult.setText("2");
        }else{
            txtResult.setText(text + "2");
        }
    }

    @FXML
    void btnTwoZerosOnAction(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            return;
        }
        txtResult.setText(text + "00");
    }

    @FXML
    void btnZeroOnAction(ActionEvent event) {
        String text = txtResult.getText();
        if(text.equals("0")){
            return;
        }
        txtResult.setText(text + "0");
    }

    @FXML
    void initialize() {
        assert btnAddition != null : "fx:id=\"btnAddition\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnDot != null : "fx:id=\"btnDot\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMemory != null : "fx:id=\"btnMemory\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMemoryAdd != null : "fx:id=\"btnMemoryAdd\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMemoryClear != null : "fx:id=\"btnMemoryClear\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMemorySubtract != null : "fx:id=\"btnMemorySubtract\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMultiplication != null : "fx:id=\"btnMultiplication\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnSubtract != null : "fx:id=\"btnSubtract\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnTwoZeros != null : "fx:id=\"btnTwoZeros\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Calculator-view.fxml'.";

    }

}

