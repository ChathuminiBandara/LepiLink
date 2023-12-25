package lk.ijse.controller.Admindashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dto.butterfltDto;
import lk.ijse.dao.Custom.ButterflyDaoImpl;

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
    public TextField avgLifeTime;
    @FXML
    public TextField currentCount;
    @FXML
    public TableView Butterfly_Table;

    public void saveButterfly() {
        if (validateFields()) {
            String BId = bId.getText();
            String Name = name.getText();
            String desc = description.getText();
            String Specie = species.getText();
            String lifetime = avgLifeTime.getText();
            String count = currentCount.getText();

            var dto = new butterfltDto(BId, Name, desc, Specie, lifetime, count);

            boolean isSaved = false;
            try {
                isSaved = new ButterflyDaoImpl().saveButterfly(dto);

                if (isSaved) {
                    System.out.println("Saved");
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();

                } else {
                    System.out.println("Not Saved");
                    new Alert(Alert.AlertType.CONFIRMATION, "Not Saved").show();

                }

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Error occurred").show();
            }
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        if (validateFields()) {
            String BId = bId.getText();
            String Name = name.getText();
            String desc = description.getText();
            String Specie = species.getText();
            String lifetime = avgLifeTime.getText();
            String count = currentCount.getText();

            var dto = new butterfltDto(BId, Name, desc, Specie, lifetime, count);

            boolean isSaved = false;
            try {
                isSaved = new ButterflyDaoImpl().updateButterfly(dto);

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

    public void SaveOnAction(ActionEvent actionEvent) {
        saveButterfly();
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException {
        String Int_Id = bId.getText();

        boolean b = ButterflyDaoImpl.deleteButterfly(Int_Id);

        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Not Deleted").show();
        }
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

        butterfltDto dto = ButterflyDaoImpl.getDetails(id);
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
