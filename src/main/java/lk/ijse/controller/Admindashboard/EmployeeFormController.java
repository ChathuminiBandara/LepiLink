package lk.ijse.controller.Admindashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.TM.EmpTM;
import lk.ijse.TM.SalaryTM;
import lk.ijse.bo.custom.EmpBO;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.dto.employeeDto;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeFormController implements Initializable {
    @FXML
    public  TextField TP;
    @FXML
    public TableView Employee_Table;
    public TextField Employee_ID;
    public TextField Employee_Name;
    public TextField StartedDate;
    public TextField Shift_Time;
    public JFXButton btnsave;
    public JFXButton btnupdate;
    public JFXButton btndelete;
    public JFXButton btnclear;

    EmpBO empBO = new EmployeeBOImpl();


    private void initUI() {
        Employee_ID.clear();
        Employee_Name.clear();
        StartedDate.clear();
        Shift_Time.clear();
        TP.clear();
        Employee_ID.setDisable(true);
        Employee_Name.setDisable(true);
        StartedDate.setDisable(true);
        Shift_Time.setDisable(true);
        TP.setDisable(true);
        Employee_ID.setEditable(false);
        Employee_Name.setDisable(false);
        StartedDate.setDisable(false);
        Shift_Time.setDisable(false);
        TP.setDisable(false);
    }
    public void saveEmployee() {
            String id = Employee_ID.getText();
            String N = Employee_Name.getText();
            String SD = StartedDate.getText();
            String ST = Shift_Time.getText();
            String T = TP.getText();

        if (btnsave.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
            try {
                if (existEmp(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                boolean isSaved = empBO.saveEmp(new employeeDto(id, N,SD,ST,T));

                if (isSaved) {
                    Employee_Table.getItems().add(new EmpTM(id, N,SD,ST,T));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            /*Update customer*/
            try {
                if (!existEmp(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such Employee associated with the id " + id).show();
                }
                employeeDto dto = new employeeDto(id, N,SD,ST,T);
                empBO.updateEmp(dto);

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Employee " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            EmpTM selectedEMp = (EmpTM) Employee_Table.getSelectionModel().getSelectedItem();
            selectedEMp.seteId(id);
            selectedEMp.seteName(N);
            Employee_Table.refresh();
        }

        //btnAddNewSalary.fire();
    }

    boolean existEmp(String id) throws SQLException, ClassNotFoundException {
        return empBO.existEmp(id);

    }

    public void SaveOnAction(ActionEvent actionEvent) {
        saveEmployee();
    }
    public void UpdateOnAction(ActionEvent actionEvent) {

    }
    public void DeleteOnAction(ActionEvent actionEvent) {

        String id = Employee_Table.getSelectionModel().getSelectedItem().toString();
        try {
            if (!existEmp(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such Salary associated with the id " + id).show();
            }
            empBO.deleteEmp(id);
            Employee_Table.getItems().remove(Employee_Table.getSelectionModel().getSelectedItem());
            Employee_Table.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        Employee_ID.clear();
        Employee_Name.clear();
        StartedDate.clear();
        Shift_Time.clear();
        TP.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization logic if needed
    }

    private boolean validateFields() {
        if (Employee_ID.getText().isEmpty() || Employee_Name.getText().isEmpty() ||
                StartedDate.getText().isEmpty() || Shift_Time.getText().isEmpty() || TP.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all fields").show();
            return false;
        }

        if (!isNumeric(TP.getText())) {
            new Alert(Alert.AlertType.ERROR, "Telephone must be numeric").show();
            return false;
        }
        return true;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
