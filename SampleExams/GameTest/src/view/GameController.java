package view;

import java.net.URL;
import java.util.ResourceBundle;

import game.EuchreGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDrawHand;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnTwoCos;

    @FXML
    private Button btnTwoCosKingQueen;

    @FXML
    private Label lblScore;

    @FXML
    private TextArea txaResult;

    private EuchreGame game;

    @FXML
    void btnDrawHandOnClick(ActionEvent event) {
        if(!game.dealHand()){
            lblScore.setText(String.valueOf(0));
        }
        txaResult.setText(game.printCards());
        lblScore.setText(String.valueOf(game.countHandStrength()));
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnTwoCosKingQueenOnClick(ActionEvent event) {
        if(game.hasKingAndQueenTrump()){
            txaResult.appendText("\n\nВ ръката има KING и QUEEN козове.");
        } else{
            txaResult.appendText("\n\nВ ръката няма KING и QUEEN козове.");
        }
    }

    @FXML
    void btnTwoCosOnClick(ActionEvent event) {
        if(game.hasKingAndQueenTrump()){
            txaResult.appendText("\n\nВ ръката има двойка козове.");
        }else{
            txaResult.appendText("\n\nВ ръката няма двойка козове.");
        }
    }

    @FXML
    void initialize() {
        assert btnDrawHand != null : "fx:id=\"btnDrawHand\" was not injected: check your FXML file 'game.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'game.fxml'.";
        assert btnTwoCos != null : "fx:id=\"btnTwoCos\" was not injected: check your FXML file 'game.fxml'.";
        assert btnTwoCosKingQueen != null : "fx:id=\"btnTwoCosKingQueen\" was not injected: check your FXML file 'game.fxml'.";
        assert lblScore != null : "fx:id=\"lblScore\" was not injected: check your FXML file 'game.fxml'.";
        assert txaResult != null : "fx:id=\"txaResult\" was not injected: check your FXML file 'game.fxml'.";

        game = new EuchreGame();
        game.shuffleCards();
    }

}

