package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class HelloWorldApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Label with "Hello, World!"
        Label label = new Label("Hello, BOB!");

        // Create a StackPane layout and add the label to it
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // Create a Scene with the StackPane as its root
        Scene scene = new Scene(root, 300, 200);

        // Set the title of the application window
        primaryStage.setTitle("Hello World JavaFX App");

        // Set the Scene for the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
