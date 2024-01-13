package lk.ijse.controller.Admindashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.entity.TM.SalaryTM;
import lk.ijse.entity.TM.SupTM;
import lk.ijse.bo.custom.SupBO;
import lk.ijse.bo.custom.impl.SupplierBOImpl;
import lk.ijse.dto.supplierDto;

import java.sql.SQLException;

public class SuppliersFormController {


    public TextField supplierId;
    public TextField supplierName;
    public TextField supplierCompanyName;
    public JFXButton btnsvae;
    public TextField qtySupplied;
    public TableView supplier_Table;
    public TextField TP;
    SupBO supBO = new SupplierBOImpl();

    public void SaveOnAction(ActionEvent actionEvent) {
        saveSupplier();
    }
    boolean existSup(String id) throws SQLException, ClassNotFoundException {
        return supBO.existSup(id);

    }
    private void initUI() {
        supplierId.clear();
        supplierName.clear();
        supplierCompanyName.clear();
        qtySupplied.clear();
        TP.clear();
        supplierId.setDisable(true);
        supplierName.setDisable(true);
        supplierCompanyName.setDisable(true);
        qtySupplied.setDisable(true);
        TP.setDisable(true);
        supplierId.setEditable(false);
        supplierName.setDisable(false);
        supplierCompanyName.setDisable(false);
        qtySupplied.setDisable(false);
        TP.setDisable(false);
    }
    public void ClearOnAction(ActionEvent actionEvent) {
        supplierId.clear();
        supplierName.clear();
        supplierCompanyName.clear();
        qtySupplied.clear();
        TP.clear();
    }
    public void saveSupplier(){
        String id = supplierId.getText();
        String spN = supplierName.getText();
        String cN = supplierCompanyName.getText();
        String qtys = qtySupplied.getText();
        String tp = TP.getText();


        if (btnsvae.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
            try {
                if (existSup(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                boolean isSaved = supBO.saveSup(new supplierDto(id,cN,qtys,tp));

                if (isSaved) {
                    supplier_Table.getItems().add(new SalaryTM(id,cN,qtys,tp));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the Supplier " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            /*Update customer*/
            try {
                if (!existSup(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
                }
                supplierDto dto = new supplierDto(id,cN,qtys,tp);
                supBO.updateSup(dto);

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the customer " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            SupTM selectedSup = (SupTM) supplier_Table.getSelectionModel().getSelectedItem();
            selectedSup.setpId(id);
            selectedSup.setSupplierName(cN);
            supplier_Table.refresh();
        }

        //btnAddNewSup.fire();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {

    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException {
        String id = supplier_Table.getSelectionModel().getSelectedItem().toString();
        try {
            if (!existSup(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such Supplier associated with the id " + id).show();
            }
            supBO.deleteSup(id);
            supplier_Table.getItems().remove(supplier_Table.getSelectionModel().getSelectedItem());
            supplier_Table.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the Supplier " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
