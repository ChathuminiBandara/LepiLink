package lk.ijse.controller.dashboard;

import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dto.empScheduleDto;
import lk.ijse.model.ButterflyModel;
import lk.ijse.model.empScheduleModel;

import java.sql.SQLException;

public class EmpSchedulesForm {
    public TableView Schedule_Table;
    public TextField Schedule_ID;
    public TextField Supervisor_Name;
    public TextField Schedule_Location;
    public TextField Date;
    public TextField Emp_ID;
    public TextField Description;
    public TextField Schedule_Note;


    public void saveEmployeeSchedule () throws SQLException {

        String scheduleId = Schedule_ID.getText();
        String supervisor = Supervisor_Name.getText();
        String scheduleLocation = Schedule_Location.getText();
        String date = Date.getText();
        String empId = Emp_ID.getText();
        String description = Description.getText();
        String scheduleNote = Schedule_Note.getText();

        var dto =  new empScheduleDto(scheduleId,supervisor,scheduleLocation,date,empId,description,scheduleNote);

        boolean isSaved = false;
        isSaved = new empScheduleModel().saveEmployeeSchedule(dto);


        if (isSaved){
            System.out.println("Saved");
        } else {
            System.out.println("Not Saved");
        }

    }
    public void SaveOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        Schedule_ID.clear();
        Supervisor_Name.clear();
        Schedule_Location.clear();
        Date.clear();
        Emp_ID.clear();
        Description.clear();
        Schedule_Note.clear();

    }
}
