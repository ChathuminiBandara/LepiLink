package lk.ijse.controller.Admindashboard;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dto.employeeDto;

import lk.ijse.model.EmployeeModel;
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



    public void saveEmployee() {
        if (validateFields()) {
            String Id = Employee_ID.getText();
            String Name = Employee_Name.getText();
            String SDate = StartedDate.getText();
            String STime = Shift_Time.getText();
            String Tel = TP.getText();

            var dto = new employeeDto(Id, Name, Tel, SDate, STime);

            boolean isSaved = false;
            try {
                isSaved = new EmployeeModel().saveEmployee(dto);

                if (isSaved) {
                    System.out.println("Saved");
                } else {
                    System.out.println("Not Saved");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        saveEmployee();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        // Placeholder for update logic
        System.out.println("Update action placeholder");
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        // Placeholder for delete logic
        System.out.println("Delete action placeholder");
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

        // Add more specific validation as needed

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
