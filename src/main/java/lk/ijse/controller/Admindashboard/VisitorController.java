package lk.ijse.controller.Admindashboard;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dto.visitorDto;
import lk.ijse.dao.visitorDaoImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VisitorController implements Initializable {
    public TableView Payment_Table;
    public TextField visitorId;
    public TextField name;
    public TextField status;
    public TextField time;
    public TextField pstatus;
    public TextField date;
    public TextField bookingId;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colStatus;
    public TableColumn colTime;
    public TableColumn colPayment;
    public TableColumn colDate;
    public TableColumn colBookId;


    public void saveVisitor() {
        if (validateFields()) {
            String VisitorId = visitorId.getText();
            String Name = name.getText();
            String Status = status.getText();
            String Time = time.getText();
            String PStatus = pstatus.getText();
            String Date = date.getText();
            String BId = bookingId.getText();

            var dto = new visitorDto(VisitorId, Name, Status, Time, PStatus, Date, BId);

            boolean isSaved = false;
            try {
                isSaved = new visitorDaoImpl().saveVisitor(dto);

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

    public void idOnAction(ActionEvent actionEvent) throws SQLException {
        String id = visitorId.getText();

        visitorDto dto = visitorDaoImpl.getDetails(id);
        if (dto == null) {
            new Alert(Alert.AlertType.ERROR, "Not Found").show();
        } else {
            name.setText(dto.getName());
            status.setText(dto.getStatus());
            time.setText(dto.getTime());
            pstatus.setText(dto.getPStatus());
            date.setText(dto.getDate());
            bookingId.setText(dto.getBId());
        }
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        saveVisitor();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String VisitorId = visitorId.getText();
        String Name = name.getText();
        String Status = status.getText();
        String Time = time.getText();
        String PStatus = pstatus.getText();
        String Date = date.getText();
        String BId = bookingId.getText();

        var dto = new visitorDto(VisitorId, Name, Status, Time, PStatus, Date, BId);

        boolean isSaved = false;
        try {
            isSaved = new visitorDaoImpl().updateVisitor(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
                System.out.println("Updated");
            } else {
                new Alert(Alert.AlertType.ERROR, "Not updated").show();
                System.out.println("Not updated");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException {
        String Int_Id = visitorId.getText();

        boolean b = visitorDaoImpl.deleteVisitor(Int_Id);

        if (b) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Not Deleted").show();
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        visitorId.clear();
        name.clear();
        status.clear();
        time.clear();
        pstatus.clear();
        date.clear();
        bookingId.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization logic if needed
    }

    private boolean validateFields() {
        if (visitorId.getText().isEmpty() || name.getText().isEmpty() || status.getText().isEmpty() ||
                time.getText().isEmpty() || pstatus.getText().isEmpty() || date.getText().isEmpty() ||
                bookingId.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all fields").show();
            return false;
        }

        // Add more specific validation as needed

        return true;
    }
}