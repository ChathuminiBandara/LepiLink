package lk.ijse.controller.Admindashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.bo.custom.impl.SalaryBOImpl;
import lk.ijse.entity.TM.SalaryTM;
import lk.ijse.bo.custom.SalaryBO;
import lk.ijse.dto.salaryDto;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SalaryFormController implements Initializable {

    public TableView<SalaryTM> Salary_Table;
    public TextField sId;
    public TextField status;
    public TextField amount;
    public TextField empId;
    public JFXButton btnsave;
    public JFXButton btndelete;
    public JFXButton btnclear;

    SalaryBO salaryBO = new SalaryBOImpl();
    boolean existSalary(String id) throws SQLException, ClassNotFoundException {
        return salaryBO.existSalary(id);

    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = sId.getText();
        String Status = status.getText();
        String Amount = amount.getText();
        String eId = empId.getText();

        if (btnsave.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
            try {
                if (existSalary(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                boolean isSaved = salaryBO.saveSalary(new salaryDto(id, Status, Amount,eId));

                if (isSaved) {
                    Salary_Table.getItems().add(new SalaryTM(id, Status, Amount,eId));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            /*Update customer*/
            try {
                if (!existSalary(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
                }
                salaryDto dto = new salaryDto(id,Status,Amount,eId);
                salaryBO.updateSalary(dto);

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the customer " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            SalaryTM selectedSalary = Salary_Table.getSelectionModel().getSelectedItem();
            selectedSalary.setsId(id);
            selectedSalary.setAmount(Amount);
            Salary_Table.refresh();
        }

        //btnAddNewSalary.fire();
    }



    private void initUI() {
        sId.clear();
        status.clear();
        amount.clear();
        empId.clear();
        sId.setDisable(true);
        status.setDisable(true);
        amount.setDisable(true);
        empId.setDisable(true);
        sId.setEditable(false);
        status.setDisable(false);
        amount.setDisable(false);
        empId.setDisable(false);
    }
    public void DeleteOnAction(ActionEvent actionEvent) {
        /*Delete Customer*/
        String id = Salary_Table.getSelectionModel().getSelectedItem().getsId();
        try {
            if (!existSalary(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such Salary associated with the id " + id).show();
            }
            salaryBO.deleteSalary(id);
            Salary_Table.getItems().remove(Salary_Table.getSelectionModel().getSelectedItem());
            Salary_Table.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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