package xyz.mglolenstine.p5c_ide;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {
    static ExecutorService executor;

    @Override
    public void start(Stage primaryStage) throws Exception{
        executor = Executors.newSingleThreadExecutor();
        Parent root = FXMLLoader.load(getClass().getResource("/ide.fxml"));
        primaryStage.setTitle("P5c IDE");
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(this.getClass().getResource("/styles/java-keywords.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop(){
        executor.shutdown();
    }
}
