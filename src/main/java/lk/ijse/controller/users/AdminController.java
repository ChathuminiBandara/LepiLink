package lk.ijse.controller.users;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    public void backOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/users/chooseUser_login.fxml"));
            AnchorPane anchorPane = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Choose User");
            newStage.setScene(new Scene(anchorPane));
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Alldashboards/Admindashboard_form.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Dashboard");
            newStage.setScene(new Scene(root));
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
