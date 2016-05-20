package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Simple Converter");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Temperature");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label celsiusLabel = new Label("Celsius:");
        grid.add(celsiusLabel, 0, 1);

        TextField celsiusTextInputView = new TextField();
        grid.add(celsiusTextInputView, 1, 1);

        Label fahrenheitLabel = new Label("Fahrenheit:");
        grid.add(fahrenheitLabel, 0, 2);

        TextField fahrenheitTextInputView = new TextField();
        grid.add(fahrenheitTextInputView, 1, 2);

        Button convertButton = new Button("Convert");
        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(convertButton);
        grid.add(hbButton, 1, 4);

        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!celsiusTextInputView.getText().isEmpty()) {
                    double celsius = Double.parseDouble(celsiusTextInputView.getText());
                    double fahrenheit = celsius * 1.8 + 32;
                    fahrenheitTextInputView.setText(String.valueOf(fahrenheit));
                } else if (!fahrenheitTextInputView.getText().isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitTextInputView.getText());
                    double celsius = (fahrenheit - 32) / 1.8;
                    celsiusTextInputView.setText(String.valueOf(celsius));
                }
            }
        });

        primaryStage.setScene(new Scene(grid, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
