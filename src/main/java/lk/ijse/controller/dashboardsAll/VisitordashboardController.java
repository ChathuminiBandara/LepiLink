package lk.ijse.controller.dashboardsAll;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class VisitordashboardController {

    public AnchorPane subpain;

    public void initialize() throws IOException {
        setform("/view/dashboard/dashboardpane_form.fxml");
    }
    private void setform(String form) throws IOException {
        URL resource = this.getClass().getResource(form);
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        subpain.getChildren().clear();
        subpain.getChildren().add(load);

    }
    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/dashboardpane_form.fxml");
    }

    public void weatherOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/weather_form.fxml");
    }

    public void populationAreaOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/population_form.fxml");
    }

    public void releasplansGeneticsOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/releasingPlans_form.fxml");
    }

    public void visitSchedulesOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/Buy.fxml");
    }

    public void visitorsOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/visitor.fxml");
    }

    public void paymentOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/payments_form.fxml");
    }

    public void aboutUsOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/aboutus.fxml");
    }

    public void logoutOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
