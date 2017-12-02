package xyz.mglolenstine.p5c_ide;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import javax.annotation.Resources;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextArea lineNumbers;
    @FXML
    WebView webView;
    @FXML
    TextArea tabText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onLoad();
    }

    @FXML
    private void handleNew(ActionEvent event){
        //System.out.println("New file event!");

    }

    @FXML
    private void updateLineCount(KeyEvent event){
        countLines();
        colorCode();
    }

    void countLines(){
        String text = (String)webView.getEngine().executeScript("document.documentElement.outerHTML");
        String[] array = text.split("\n");
        String text2 = "";
        for(int i = 1; i <= array.length; i++){
            text2+=i+"\n";
        }
        lineNumbers.setText(text2);
        //System.out.println("We currently have "+(array.length)+ " lines in the first tab!");
    }

    void colorCode(){

    }

    void onLoad(){
        WebEngine engine = webView.getEngine();
        engine.setJavaScriptEnabled(true);
        engine.setOnAlert(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> event) {
                String data = event.getData();
                System.out.println("alert: " + data);
                tabText.appendText(data);
            }
        });
        //engine.load(this.getClass().getResource("websites/tabEdit.html").toExternalForm());
        engine.load("http://google.com");
        System.out.println("Website load finished!");
    }
}
