package lk.ijse.controller.Admindashboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WeatherController extends Application {
    private WebView webView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        webView = new WebView();

        Button weatherButton = new Button("Load Weather");
        weatherButton.setOnAction(this::weatherONAction);

        VBox layout = new VBox(weatherButton, webView);
        Scene scene = new Scene(layout, 800, 600);

        primaryStage.setTitle("Weather App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void weatherONAction(javafx.event.ActionEvent actionEvent) {
        webView.getEngine().load("https://www.bbc.com/weather/1248991");


    }

    public void onActionOpenweather(ActionEvent actionEvent) throws URISyntaxException, IOException {
        System.out.println("onActionOpenweather");
        System.out.println("Link Clicked");
        Desktop.getDesktop().browse(new URI("https://www.bbc.com/weather/1248991"));
    }
}

