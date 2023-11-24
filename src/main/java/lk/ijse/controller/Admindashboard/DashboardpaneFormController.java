package lk.ijse.controller.Admindashboard;

import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DashboardpaneFormController {
    public Label lblTime;
    public Label lblDate;

    public void initialize() {
        lblTime.setText(new SimpleDateFormat("hh:mm a").format(new Date()));
        lblDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
    }

}