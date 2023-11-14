package lk.ijse.controller.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.dto.butterfltDto;
import lk.ijse.model.ButterflyModel;

import java.net.URL;
import java.sql.ResultSet;
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

    public void saveButterfly()  {
        String BId = bId.getText();
        String Name = name.getText();
        String desc = description.getText();
        String Specie = species.getText();
        String lifetime = avgLifeTime.getText();
        String count = currentCount.getText();

        var dto =  new butterfltDto(BId,Name,desc,Specie,lifetime,count);


        boolean isSaved = false;
        try {
            isSaved = new ButterflyModel().saveButterfly(dto);


        if (isSaved){
            System.out.println("Saved");
            new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();

        } else {
            System.out.println("Not Saved");
            new Alert(Alert.AlertType.CONFIRMATION,"Not Saved").show();

        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void SaveOnAction(ActionEvent actionEvent) {
        saveButterfly();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String BId = bId.getText();
        String Name = name.getText();
        String desc = description.getText();
        String Specie = species.getText();
        String lifetime = avgLifeTime.getText();
        String count = currentCount.getText();

        var dto =  new butterfltDto(BId,Name,desc,Specie,lifetime,count);

        boolean isSaved = false;
        try {
            isSaved = new ButterflyModel().updateButterfly(dto);

            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"updated").show();
                System.out.println("updated");
            } else {
                new Alert(Alert.AlertType.ERROR,"Not updated").show();
                System.out.println("Not updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException {
        String Int_Id = bId.getText();

        boolean b = ButterflyModel.deleteButterfly(Int_Id);

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

        butterfltDto dto = ButterflyModel.getDetails(id);
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
