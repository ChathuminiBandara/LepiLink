package lk.ijse.controller.Admindashboard;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dto.supplierDto;
import lk.ijse.dao.Custom.supplierDaoImpl;

import java.sql.SQLException;

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
        saveSupplier();
    }
    public void saveSupplier(){
        String SupplierId = Sup_ID.getText();
        String SupplierName = Sup_Name.getText();
        String CompanyName = CompanyNAme.getText();
        String Description = this.Description.getText();
        String QtySupplied = this.QtySupplied.getText();
        String ProductSupplied = this.ProductSupplied.getText();

        var dto = new supplierDto(SupplierId,SupplierName,CompanyName,Description,QtySupplied,ProductSupplied);
        boolean isSaved = false;
        try {
            isSaved = new supplierDaoImpl().saveSupplier(dto);
            if (isSaved){
                System.out.println("Saved");
            } else {
                System.out.println("Not Saved");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = Sup_ID.getText();
        String name = Sup_Name.getText();
        String companyName = CompanyNAme.getText();
        String description = Description.getText();
        String qtySupplied = QtySupplied.getText();
        String productSupplied = ProductSupplied.getText();

        var dto = new supplierDto(id,name,companyName,description,qtySupplied,productSupplied);
        try {
            boolean isUpdated = new supplierDaoImpl().updateSupplier(dto);
            if (isUpdated){
                System.out.println("Updated");
            } else {
                System.out.println("Not Updated");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException {
       String id = Sup_ID.getText();
       try {
           boolean isDeleted = new supplierDaoImpl().deleteSupplier(id);
           if (isDeleted) {
               System.out.println("Deleted");
           } else {
               System.out.println("Not Deleted");
           }
       }catch (SQLException e){
           new Alert(Alert.AlertType.WARNING, "Something went wrong!").show();
       }

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
