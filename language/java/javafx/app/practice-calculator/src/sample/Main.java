package sample;

import com.danialgoodwin.practice.CalcApp;
import com.danialgoodwin.practice.CalcAppViaCode;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CalcApp calcAppViaCode = new CalcAppViaCode();

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(20);
        Button button = new Button("Calc via code");
        root.add(button, 0, 0);

        button.setOnAction(event -> calcAppViaCode.show());

        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


}
