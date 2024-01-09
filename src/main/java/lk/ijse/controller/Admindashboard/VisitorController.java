package lk.ijse.controller.Admindashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.TM.SalaryTM;
import lk.ijse.TM.VisitorTM;
import lk.ijse.bo.custom.VisitorBO;
import lk.ijse.bo.custom.impl.VisitoBOImpl;
import lk.ijse.dao.custom.impl.VisitorDaoImpl;
import lk.ijse.dto.salaryDto;
import lk.ijse.dto.visitorDto;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import lk.ijse.TM.VisitorTM;


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
    public JFXButton btnsave;
    public JFXButton btnupdate;
    public JFXButton btndelete;
    VisitorBO visitorBO = new VisitoBOImpl();

    public void idOnAction(ActionEvent actionEvent) throws SQLException {

    }
    boolean existVisitor(String id) throws SQLException, ClassNotFoundException {
        return visitorBO.existVisitor(id);

    }
    public void SaveOnAction(ActionEvent actionEvent) {
        String id = visitorId.getText();
        String n = name.getText();
        String st = status.getText();
        String t = time.getText();
        String ps = pstatus.getText();
        String dt = date.getText();
        String bk = bookingId.getText();

        if (btnsave.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
            try {
                if (existVisitor(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                boolean isSaved = visitorBO.saveVisitor(new visitorDto(id,n,st,t,ps,dt,bk));

                if (isSaved) {
                    Payment_Table.getItems().add(new VisitorTM(id,n,st,t,ps,dt,bk));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            /*Update customer*/
            try {
                if (!existVisitor(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
                }
                visitorDto dto = new visitorDto(id,n,st,t,ps,dt,bk);
                visitorBO.updateVisitor(dto);

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the customer " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            VisitorTM selectedVisitor = (VisitorTM) Payment_Table.getSelectionModel().getSelectedItem();
            selectedVisitor.setVisitorId(id);
            selectedVisitor.setVisitorName(n);
            selectedVisitor.setDate(dt);
            selectedVisitor.setStatus(st);
            selectedVisitor.setTime(t);
            Payment_Table.refresh();
        }

        //btnAddNewVisitor.fire();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {

    }


    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = Payment_Table.getSelectionModel().getSelectedItem().getVisitorId();
        try {
            if (!existVisitor(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such Visitor associated with the id " + id).show();
            }
            visitorBO.deleteVisitor(id);
            Payment_Table.getItems().remove(Payment_Table.getSelectionModel().getSelectedItem());
            Payment_Table.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the Visitor " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
    private void initUI() {
        visitorId.clear();
        name.clear();
        status.clear();
        time.clear();
        pstatus.clear();
        date.clear();
        bookingId.clear();
        visitorId.setDisable(true);
        name.setDisable(true);
        status.setDisable(true);
        time.setDisable(true);
        pstatus.setDisable(true);
        date.setDisable(true);
        bookingId.setDisable(true);
        visitorId.setEditable(false);
        name.setDisable(false);
        status.setDisable(false);
        time.setDisable(false);
        pstatus.setDisable(false);
        date.setDisable(false);
        bookingId.setDisable(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization logic if needed
    }

}