/**
 * Created by Danial on 3/11/2015.
 */
package com.danialgoodwin.javafx.helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** The initial class that will run. */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        StackPane root = new StackPane();
        root.getChildren().add(newButton("Hello Button!"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275, Color.WHEAT));
        primaryStage.show();
    }

    private Button newButton(final String title) {
        Button button = new Button(title);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showAlert(title, title + " message!");
                System.out.println("title=" + title);
            }
        });
        return button;
    }

    // More info: http://stackoverflow.com/questions/8309981/how-to-create-and-show-common-dialog-error-warning-confirmation-in-javafx-2
    // After JavaFX 8u40, can use official Alerts: http://code.makery.ch/blog/javafx-dialogs-official/
    private void showAlert(String title, String message) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text(message), new Button("OK (this does nothing for now)")).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
        dialogStage.sizeToScene();
        dialogStage.show();
    }

}
