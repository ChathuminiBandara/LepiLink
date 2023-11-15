package lk.ijse.controller.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dto.salaryDto;
import lk.ijse.model.ButterflyModel;
import lk.ijse.model.salaryModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SalaryFormController implements Initializable {
    @FXML
    TableView Salary_Table;
    @FXML
    public TextField sId;
    @FXML
    public TextField status;
    @FXML
    public TextField amount;
    @FXML
    public TextField empId;


    public void saveSalary(){
        String SId = sId.getText();
        String Status = status.getText();
        String Amount = amount.getText();
        String EmpId = empId.getText();

        var dto =  new salaryDto(SId,Status,Amount,EmpId);

        boolean isSaved = false;
        try {
            isSaved = new salaryModel().saveSalary(dto);


            if (isSaved){
                System.out.println("Saved");
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();

            } else {
                System.out.println("Not Saved");
                new Alert(Alert.AlertType.CONFIRMATION,"Not Saved").show();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void SaveOnAction(ActionEvent actionEvent) {
        saveSalary();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        sId.clear();
        status.clear();
        amount.clear();
        empId.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
