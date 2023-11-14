package lk.ijse.controller.dashboard;

import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmpTaskForm {
    public TableView Tasks_Table;
    public TextField Task_ID;
    public TextField Description;
    public TextField completionDate;
    public TextField created_Day;
    public TextField notes;
    public TextField status;

    public void SaveOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        Task_ID.clear();
        Description.clear();
        completionDate.clear();
        created_Day.clear();
        notes.clear();
        status.clear();

    }
}
