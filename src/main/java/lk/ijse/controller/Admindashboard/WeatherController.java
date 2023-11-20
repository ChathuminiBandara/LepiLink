package lk.ijse.controller.Admindashboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WeatherController extends Application {


    public void onActionOpenweather(ActionEvent actionEvent) throws URISyntaxException, IOException {
        System.out.println("onActionOpenweather");
        System.out.println("Link Clicked");
        Desktop.getDesktop().browse(new URI("https://www.bbc.com/weather/1248991"));
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}

