/**
 * 2016-05-22: Created by Danial Goodwin
 */
package com.danialgoodwin.practice;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**  */
public class CalcAppViaCode extends CalcApp {

    private GridPane root;
    private TextField num1Field, num2Field;
    private Button addButton, divButton, subButton, mulButton, clearButton;
    private Label answerLabel;

    public CalcAppViaCode() {
        num1Field = new TextField();
        num2Field = new TextField();
        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        clearButton = new Button("Clear");
        answerLabel = new Label("?");
        answerLabel.setAlignment(Pos.CENTER);
        answerLabel.setStyle("-fx-border-colof: #000; -fx-padding: 5px");

        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.add(addButton, 0, 0);
        root.add(subButton, 1, 0);
        root.add(mulButton, 0, 1);
        root.add(divButton, 1, 1);
        root.add(num1Field, 0, 2);
        root.add(num2Field, 1, 2);
        root.add(answerLabel, 0, 3, 2, 1);
        root.add(clearButton, 0, 4, 2, 1);

        setWidths();
        attachCode();
    }

    private void setWidths() {
        num1Field.setPrefWidth(70);
        num2Field.setPrefWidth(70);
        addButton.setPrefWidth(70);
        subButton.setPrefWidth(70);
        mulButton.setPrefWidth(70);
        divButton.setPrefWidth(70);
        clearButton.setPrefWidth(150);
        answerLabel.setPrefWidth(150);
    }

    private void attachCode() {
        addButton.setOnAction(this::addButtonAction);
        subButton.setOnAction(this::addButtonAction);
        mulButton.setOnAction(this::addButtonAction);
        divButton.setOnAction(this::addButtonAction);
        clearButton.setOnAction(this::addButtonAction);
    }
    private void addButtonAction(ActionEvent e) {
        if (e.getSource() == clearButton) {
            num1Field.setText("");
            num2Field.setText("");
            answerLabel.setText("?");
            num1Field.requestFocus();
            return;
        }
        int answer = 0;
        char symbol = ' ';
        if (num1Field.getText().equals("")) { num1Field.setText("0"); }
        if (num2Field.getText().equals("")) { num2Field.setText("0"); }
        int num1 = parseIntOrElse(num1Field.getText(), 0);
        int num2 = parseIntOrElse(num2Field.getText(), 0);
        if (e.getSource() == addButton) {
            symbol = '+';
            answer = num1 + num2;
        } else if (e.getSource() == subButton) {
            symbol = '-';
            answer = num1 - num2;
        } else if (e.getSource() == mulButton) {
            symbol = '*';
            answer = num1 * num2;
        } else if (e.getSource() == divButton) {
            symbol = '/';
            answer = num2 == 0 ? 0 : num1 / num2;
        }
        answerLabel.setText("" + num1 + symbol + num2 + "=" + answer);
    }

    private static int parseIntOrElse(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void show() {
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

}
