package lk.ijse.controller.Admindashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.TM.SalaryTM;
import lk.ijse.bo.custom.ButterflyBO;
import lk.ijse.bo.custom.impl.ButterflyBOImpl;
import lk.ijse.dto.butterflyDto;
import lk.ijse.dao.custom.impl.ButterflyDAOImpl;
import lk.ijse.TM.ButterflyTM;
import lk.ijse.dto.salaryDto;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ButterflyFxmlController implements Initializable {

   @FXML
   public TextField bId;
    @FXML
    public TextField name;
    @FXML
    public TextField description;
    @FXML
    public TextField species;
    @FXML
    public JFXButton btnDelete;
    @FXML
    public JFXButton btnSave;
    @FXML
    public TextField avgLifeTime;
    @FXML
    public TextField currentCount;
    @FXML
    public TableView<ButterflyTM> Butterfly_Table;
    public JFXButton add_new;
    ButterflyBO butterflyBO = new ButterflyBOImpl();


    public void idOnAction(ActionEvent actionEvent) {
    }
    boolean existButterfly(String id) throws SQLException, ClassNotFoundException {
        return butterflyBO.existButterfly(id);

    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = bId.getText();
        String Name = name.getText();
        String dec = description.getText();
        String Species = species.getText();
        String AVG = avgLifeTime.getText();
        String cc = currentCount.getText();
        if (btnSave.getText().equalsIgnoreCase("save")) {
            /*Save Butterfly*/
            try {
                if (existButterfly(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                boolean isSaved = ButterflyBO.saveButterfly(new butterflyDto(id, Name, dec,Species,AVG,cc));

                if (isSaved) {
                    Butterfly_Table.getItems().add(new ButterflyTM(id,Name, dec,Species,AVG,cc));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the Butterfly " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            /*Update Butterfly*/
            try {
                if (!existButterfly(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
                }
                butterflyDto dto = new butterflyDto(id,Name, dec,Species,AVG,cc);
                butterflyBO.updateButterfly(dto);

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Butterfly " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ButterflyTM selecteBtt = Butterfly_Table.getSelectionModel().getSelectedItem();
            selecteBtt.setbId(id);
            selecteBtt.setName(Name);
            selecteBtt.setDescription(dec);
            selecteBtt.setSpecies(Species);
            selecteBtt.setAvgLifeTime(AVG);
            selecteBtt.setCurrentCount(cc);
            Butterfly_Table.refresh();
        }

        //btnAddNewButterfly.fire();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }
    private void initUI() {
        bId.clear();
        name.clear();
        description.clear();
        species.clear();
        avgLifeTime.clear();
        currentCount.clear();
        bId.setDisable(true);
        name.setDisable(true);
        species.setDisable(true);
        avgLifeTime.setDisable(true);
        currentCount.setDisable(true);
        bId.setDisable(false);
        name.setDisable(false);
        description.setDisable(false);
        species.setDisable(false);
        avgLifeTime.setDisable(false);
        currentCount.setDisable(false);
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        /*Delete Customer*/
        String id = Butterfly_Table.getSelectionModel().getSelectedItem().getbId();
        try {
            if (!butterflyBO.existButterfly(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such Salary associated with the id " + id).show();
            }
            ButterflyBO.deleteButterfly(id);
            Butterfly_Table.getItems().remove(Butterfly_Table.getSelectionModel().getSelectedItem());
            Butterfly_Table.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the Butterfly " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnaddnewbutterfly(ActionEvent actionEvent) {
    }
    public void ClearOnAction(ActionEvent actionEvent) {
        bId.clear();
        name.clear();
        description.clear();
        species.clear();
        avgLifeTime.clear();
        currentCount.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
