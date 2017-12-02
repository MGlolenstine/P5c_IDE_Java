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

public class Main extends Application {
    @FXML
    TabPane tabPane;
    @FXML
    TextArea consoleOutput;
    @FXML
    WebView webView;
    @FXML
    TextArea tabText;

    static Stage primaryStage;

    static Main main;
    @Override
    public void start(Stage primaryStage_) throws Exception{
        primaryStage = primaryStage_;
        Parent root = FXMLLoader.load(getClass().getResource("ide.fxml"));
        primaryStage.setTitle("P5c IDE");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
