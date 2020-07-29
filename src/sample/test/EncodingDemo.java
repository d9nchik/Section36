package sample.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EncodingDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final File file = new File("temp.txt");
        try (PrintWriter output = new PrintWriter(file)) {
            output.print("\u6B22\u8FCE Welcome \u03b1\u03b2\u03b3");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try (Scanner input = new Scanner(file)) {
            StackPane pane = new StackPane();
            pane.getChildren().add(new Text(input.nextLine()));
            // Create a scene and place it in the stage
            Scene scene = new Scene(pane, 200, 200);
            primaryStage.setTitle("EncodingDemo"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!file.delete()) {
            System.out.println("Problem with removing rubbish.");
        }
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
