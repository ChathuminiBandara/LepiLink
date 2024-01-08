package lk.ijse.controller.Admindashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.bo.Custom.ButterflyBO;
import lk.ijse.bo.Custom.Impl.ButterflyBOImpl;
import lk.ijse.dto.butterflyDto;
import lk.ijse.dao.Custom.Impl.ButterflyDaoImpl;
import lk.ijse.view.tdm.ButterflyTM;

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
    //private ButterflyDaoImpl butterflyDaoImpl = new ButterflyDaoImpl();
    ButterflyBO butterflyBO = new ButterflyBOImpl();

    public void SaveOnAction(ActionEvent actionEvent) throws SQLException, CloneNotSupportedException{
        String id = bId.getText();
        String Name = name.getText();
        String decs = description.getText();
        String sp = species.getText();
        String lt = avgLifeTime.getText();
        String c = currentCount.getText();


        if (!Name.matches("[A-Za-z ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            //Name.requestFocus();
            return;
        } else if (!decs.matches(".{3,}")) {
            new Alert(Alert.AlertType.ERROR, "Description  should be at least 3 characters long").show();
           // decs.requestFocus();
            return;
        }

        if (btnSave.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
            try {
                if (existButterfly(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                boolean isSaved = ButterflyBO.saveButterfly(new butterflyDto(id, Name, decs, sp, lt, c ));

                if (isSaved) {
                    Butterfly_Table.getItems().add(new ButterflyTM(id, Name, decs,sp,lt,c));
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            /*Update customer*/
            try {
                if (!existButterfly(id)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
                }
                butterflyDto dto = new butterflyDto(id,Name,decs,sp,lt,c);
                ButterflyBO.updateButterfly(dto);

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the customer " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ButterflyTM selectedButterfly = Butterfly_Table.getSelectionModel().getSelectedItem();
            selectedButterfly.setName(Name);
            //selectedCustomer.setAddress(address);
            Butterfly_Table.refresh();
        }

        //btnAddNewCustomer.fire();
    }


    public void UpdateOnAction(ActionEvent actionEvent) {
        if (validateFields()) {
            String BId = bId.getText();
            String Name = name.getText();
            String desc = description.getText();
            String Specie = species.getText();
            String lifetime = avgLifeTime.getText();
            String count = currentCount.getText();

            var dto = new butterflyDto(BId, Name, desc, Specie, lifetime, count);

            boolean isSaved = false;
            try {
                isSaved = new ButterflyDaoImpl().update(dto);

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
                    System.out.println("Updated");
                } else {
                    new Alert(Alert.AlertType.ERROR, "Not Updated").show();
                    System.out.println("Not Updated");
                }

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Error occurred").show();
            }
        }
    }

    private boolean validateFields() {
        if (bId.getText().isEmpty() || name.getText().isEmpty() || description.getText().isEmpty() ||
                species.getText().isEmpty() || avgLifeTime.getText().isEmpty() || currentCount.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all fields").show();
            return false;
        }

        if (!isNumeric(avgLifeTime.getText()) || !isNumeric(currentCount.getText())) {
            new Alert(Alert.AlertType.ERROR, "Average Lifetime and Current Count must be numeric").show();
            return false;
        }

        return true;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void DeleteOnAction(ActionEvent actionEvent) {
        /*Delete Customer*/
        String id = Butterfly_Table.getSelectionModel().getSelectedItem().getbId();
        try {
            if (!existButterfly(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
            }
            ButterflyBO.deleteButterfly(id);
            Butterfly_Table.getItems().remove(Butterfly_Table.getSelectionModel().getSelectedItem());
            Butterfly_Table.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        description.setDisable(true);
        species.setDisable(true);
        avgLifeTime.setDisable(true);
        currentCount.setDisable(true);
        bId.setEditable(false);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
    }
    boolean existButterfly(String id) throws SQLException, ClassNotFoundException {
        return butterflyBO.existButterfly(id);

    }

    public void ClearOnAction(ActionEvent actionEvent) {
        bId.clear();
        name.clear();
        description.clear();
        species.clear();
        avgLifeTime.clear();
        currentCount.clear();

    }

    public void idOnAction(ActionEvent actionEvent) throws SQLException {
        String id = bId.getText();

        butterflyDto dto = ButterflyBOImpl.getDetails(id);
        if (dto == null){
            new Alert(Alert.AlertType.ERROR,"Not Found").show();
        } else {
            name.setText(dto.getName());
            description.setText(dto.getDesc());
            species.setText(dto.getSpecies());
            avgLifeTime.setText(dto.getLifeTime());
            currentCount.setText(dto.getCount());
        }
    }
}
