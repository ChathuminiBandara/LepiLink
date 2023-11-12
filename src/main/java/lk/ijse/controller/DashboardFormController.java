package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class DashboardFormController {
    public AnchorPane subpain;


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

    public void butterflyOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/butterfly_form.fxml");
    }

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/employee_Form.fxml");
    }

    public void weatherOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/weather_form.fxml");
    }

    public void populationOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/population_form.fxml");
    }

    public void releasplansOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/releasingPlans_form.fxml");
    }


    public void geneticDataOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/genetic_data_form.fxml");
    }


    public void paymentOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/payments_form.fxml");
    }

    public void suppliersOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/suppliers_form.fxml");
    }


    public void tasksOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/emp_Task_form.fxml");
    }

    public void visitSchedulesOnAction(ActionEvent actionEvent) throws IOException {
        setform("/view/dashboard/visit_scheduls_form.fxml");
    }
}
