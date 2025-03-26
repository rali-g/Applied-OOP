import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

import static javafx.scene.paint.Color.RED;

public class MyCalendarController {

    @FXML
    private URL location;

    @FXML
    private Label label00;

    @FXML
    private Label label01;

    @FXML
    private Label label02;

    @FXML
    private Label label03;

    @FXML
    private Label label04;

    @FXML
    private Label label05;

    @FXML
    private Label label06;

    @FXML
    private Label label10;

    @FXML
    private Label label11;

    @FXML
    private Label label12;

    @FXML
    private Label label13;

    @FXML
    private Label label14;

    @FXML
    private Label label15;

    @FXML
    private Label label16;

    @FXML
    private Label label20;

    @FXML
    private Label label21;

    @FXML
    private Label label22;

    @FXML
    private Label label23;

    @FXML
    private Label label24;

    @FXML
    private Label label25;

    @FXML
    private Label label26;

    @FXML
    private Label label30;

    @FXML
    private Label label31;

    @FXML
    private Label label32;

    @FXML
    private Label label33;

    @FXML
    private Label label34;

    @FXML
    private Label label35;

    @FXML
    private Label label36;

    @FXML
    private Label label40;

    @FXML
    private Label label41;

    @FXML
    private Label label42;

    @FXML
    private Label label43;

    @FXML
    private Label label44;

    @FXML
    private Label label45;

    @FXML
    private Label label46;

    @FXML
    private Label label50;

    @FXML
    private Label label51;

    @FXML
    private Label label52;

    @FXML
    private Label label53;

    @FXML
    private Label label54;

    @FXML
    private Label label55;

    @FXML
    private Label label56;

    @FXML
    private GridPane resources;

    private ArrayList<ArrayList<Label>> calendar = new ArrayList<>();

    @FXML
    void initialize() {
        int month = getMonth();
        int year = getYear();

        LocalDate currentDate = LocalDate.now();
        boolean exists = currentDate.getMonth().getValue() == month;

        LocalDate date = LocalDate.of(year, month, 1);
        int currentDay = date.getDayOfWeek().getValue();
        initializeCalendar();

        for (int i = 0; i < currentDay - 1; i++) {
            calendar.get(0).get(i).setText("");
        }
        int iter = 1;
        int maxMonthLength = date.lengthOfMonth();
        for (int i = currentDay - 1; i < 7; i++) {
            if(exists && iter == currentDate.getDayOfMonth()) {
                calendar.get(0).get(i).setTextFill(RED);
            }
            calendar.get(0).get(i).setText(String.valueOf(iter++));
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(exists && iter == currentDate.getDayOfMonth()) {
                    calendar.get(i).get(j).setTextFill(RED);
                }
                if (iter > maxMonthLength) {
                    return;
                }
                calendar.get(i).get(j).setText(String.valueOf(iter++));
            }
        }
    }

    private void initializeCalendar() {
        for (int i = 0; i < 6; i++) {
            calendar.add(new ArrayList<>());
        }
        calendar.get(0).add(label00);
        calendar.get(0).add(label01);
        calendar.get(0).add(label02);
        calendar.get(0).add(label03);
        calendar.get(0).add(label04);
        calendar.get(0).add(label05);
        calendar.get(0).add(label06);
        calendar.get(1).add(label10);
        calendar.get(1).add(label11);
        calendar.get(1).add(label12);
        calendar.get(1).add(label13);
        calendar.get(1).add(label14);
        calendar.get(1).add(label15);
        calendar.get(1).add(label16);
        calendar.get(2).add(label20);
        calendar.get(2).add(label21);
        calendar.get(2).add(label22);
        calendar.get(2).add(label23);
        calendar.get(2).add(label24);
        calendar.get(2).add(label25);
        calendar.get(2).add(label26);
        calendar.get(3).add(label30);
        calendar.get(3).add(label31);
        calendar.get(3).add(label32);
        calendar.get(3).add(label33);
        calendar.get(3).add(label34);
        calendar.get(3).add(label35);
        calendar.get(3).add(label36);
        calendar.get(4).add(label40);
        calendar.get(4).add(label41);
        calendar.get(4).add(label42);
        calendar.get(4).add(label43);
        calendar.get(4).add(label44);
        calendar.get(4).add(label45);
        calendar.get(4).add(label46);
        calendar.get(5).add(label50);
        calendar.get(5).add(label51);
        calendar.get(5).add(label52);
        calendar.get(5).add(label53);
        calendar.get(5).add(label54);
        calendar.get(5).add(label55);
        calendar.get(5).add(label56);
    }

    private int getMonth() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter month:");

        int month;
        do {
            dialog.getEditor().clear();
            month = Integer.parseInt(dialog.showAndWait().get());
            if (month < 1 || month > 12) {
                displayMonthErrorDialog();
            }
        }
        while (month < 1 || month > 12);

        return month;
    }

    private int getYear() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter year:");

        int year;
        do {
            dialog.getEditor().clear();
            year = Integer.parseInt(dialog.showAndWait().get());
            if (year < 1000 || year > 2050) {
                displayYearErrorDialog();
            }
        }
        while (year < 1000 || year > 2050);
        return year;
    }

    private void displayMonthErrorDialog() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(String.format("Wrong input!\n" + "Valid months are: 1 - 12"));
        alert.showAndWait();
    }

    private void displayYearErrorDialog() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(String.format("Wrong input!\n" + "Valid years: 1000 - 2050"));
        alert.showAndWait();
    }
}
