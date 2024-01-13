package lk.ijse.controller.Admindashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.entity.TM.PayTM;
import lk.ijse.bo.custom.PayBO;
import lk.ijse.bo.custom.impl.PaymentBOImpl;
import lk.ijse.dto.paymentDto;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaymentsForm implements Initializable {
    public JFXButton btnsave;
    @FXML
    private AnchorPane root;
    public  TextField TP;
    public TableView payment_Table;
    public TextField PId;
    public TextField Vname;
    public TextField status;
    PayBO payBO = new PaymentBOImpl();
    public void savePayment()  {
        String id = PId.getText();
        String vn = Vname.getText();
        String ps = status.getText();
        String vc = TP.getText();
        if (btnsave.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
            try {
                if (existPay(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                boolean isSaved = payBO.savePay(new paymentDto(id, vn, ps,vc));

                if (isSaved) {
                    payment_Table.getItems().add(new PayTM(id, vn, ps,vc));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            /*Update customer*/
            try {
                if (!existPay(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
                }
                paymentDto dto = new paymentDto(id,vn, ps,vc);
                payBO.updatePay(dto);

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Payment " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            PayTM selectedPay = (PayTM) payment_Table.getSelectionModel().getSelectedItem();
            selectedPay.setId(id);
            selectedPay.setVn(vn);
            payment_Table.refresh();
        }

        //btnAddNewSalary.fire();
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        savePayment();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        PId.clear();
        Vname.clear();
        status.clear();
        TP.clear();
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = payment_Table.getSelectionModel().getSelectedItem().toString();
        try {
            if (!existPay(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such Payment associated with the id " + id).show();
            }
            payBO.deletePay(id);
            payment_Table.getItems().remove(payment_Table.getSelectionModel().getSelectedItem());
            payment_Table.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initUI() {
        PId.clear();
        Vname.clear();
        status.clear();
        TP.clear();
        PId.setDisable(true);
        Vname.setDisable(true);
        status.setDisable(true);
        TP.setDisable(true);
        PId.setEditable(false);
        Vname.setDisable(false);
        status.setDisable(false);
        TP.setDisable(false);
    }

    boolean existPay(String id) throws SQLException, ClassNotFoundException {
        return payBO.existPay(id);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
