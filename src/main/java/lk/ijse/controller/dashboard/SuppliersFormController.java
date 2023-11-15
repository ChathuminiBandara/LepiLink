package lk.ijse.controller.dashboard;

import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SuppliersFormController {
    public TableView Suppliers_Table;
    public TextField Sup_ID;
    public TextField Sup_Name;
    public TextField CompanyNAme;
    public TextField Description;
    public TextField QtySupplied;
    public TextField ProductSupplied;
    public TableView payment_Table;

    public void SaveOnAction(ActionEvent actionEvent) {
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        Sup_ID.clear();
        Sup_Name.clear();
        CompanyNAme.clear();
        Description.clear();
        QtySupplied.clear();
        ProductSupplied.clear();
    }
}
