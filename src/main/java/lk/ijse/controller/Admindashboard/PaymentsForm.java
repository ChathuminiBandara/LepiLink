package lk.ijse.controller.Admindashboard;

//import com.sun.javafx.tk.quantum.PaintRenderJob;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.paymentDto;
import lk.ijse.model.paymentModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaymentsForm implements Initializable {
    @FXML
    private AnchorPane root;
    public  TextField TP;
    public TableView payment_Table;
    public TextField PId;
    public TextField Vname;
    public TextField status;

    public void savePayment()  {
        String paymentId = PId.getText();
        String visitorName = Vname.getText();
        String paymentStatus = status.getText();
        String visitorContactNum = TP.getText();
        var dto =  new paymentDto(paymentId,visitorName,paymentStatus,visitorContactNum);

        boolean isSaved = false;
        try {
            isSaved = new paymentModel().savePayment(dto);


            if (isSaved){
                System.out.println("Saved");
            } else {
                System.out.println("Not Saved");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        savePayment();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        PId.clear();
        Vname.clear();
        status.clear();
        TP.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    
}
