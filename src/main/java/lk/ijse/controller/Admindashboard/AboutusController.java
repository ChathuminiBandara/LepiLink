package lk.ijse.controller.Admindashboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutusController  extends Application {



    public void openDilmahOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        System.out.println("onActionOpenDilmah");
        System.out.println("Link Clicked");
        Desktop.getDesktop().browse(new URI("https://www.dilmahconservation.org/"));
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
