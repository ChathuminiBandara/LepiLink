package lk.ijse.controller.Admindashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VisitschedulsForm {
    @FXML
    private AnchorPane root;


    public void customerOnAction(ActionEvent actionEvent) {
        try {
            // Load the content from customer_form.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard/customer_form.fxml"));
            AnchorPane anchorPane = loader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Customer Manage");

            // Set the scene with the loaded content
            newStage.setScene(new Scene(anchorPane));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void itemOnaction(ActionEvent actionEvent) {
        try {
            // Load the content from item_form.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard/item_form.fxml"));
            AnchorPane anchorPane = loader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Item Manage");

            // Set the scene with the loaded content
            newStage.setScene(new Scene(anchorPane));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void placeOrderOnAction(ActionEvent actionEvent) {
        try {
            // Load the content from placeorder_form.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard/placeorder_form.fxml"));
            AnchorPane anchorPane = loader.load();

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Place Order");

            // Set the scene with the loaded content
            newStage.setScene(new Scene(anchorPane));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
