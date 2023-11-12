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
   public TextField Butterfly_INtrntnl_Variety_ID;
    @FXML
    public TextField Variety_Name;
    @FXML
    public TextField Avg_lifetime;
    @FXML
    public TextField Description;
    @FXML
    public TextField Species_Name;
    @FXML
    public TextField Current_Count;
    @FXML
    public TableView Butterfly_Table;

    public void saveButterfly()  {
        String Int_Id = Butterfly_INtrntnl_Variety_ID.getText();
        String Variety_Name1 = Variety_Name.getText();
        String Avg_Life_Time = Avg_lifetime.getText();
        String Description1 = Description.getText();
        String Species_Name1 = Species_Name.getText();
        String Current_Count1 = Current_Count.getText();

      var dto =  new butterfltDto(Int_Id,Variety_Name1,Description1,Avg_Life_Time,Species_Name1,Current_Count1);


        boolean isSaved = false;
        try {
            isSaved = new ButterflyModel().saveButterfly(dto);


        if (isSaved){
            System.out.println("Saved");
        } else {
            System.out.println("Not Saved");
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
        String Int_Id = Butterfly_INtrntnl_Variety_ID.getText();
        String Variety_Name1 = Variety_Name.getText();
        String Avg_Life_Time = Avg_lifetime.getText();
        String Description1 = Description.getText();
        String Species_Name1 = Species_Name.getText();
        String Current_Count1 = Current_Count.getText();

        var dto =  new butterfltDto(Int_Id,Variety_Name1,Description1,Avg_Life_Time,Species_Name1,Current_Count1);

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
        String Int_Id = Butterfly_INtrntnl_Variety_ID.getText();

        boolean b = ButterflyModel.deleteButterfly(Int_Id);

        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Not Deleted").show();
        }

    }

    public void ClearOnAction(ActionEvent actionEvent) {
        Butterfly_INtrntnl_Variety_ID.clear();
        Variety_Name.clear();
        Avg_lifetime.clear();
        Description.clear();
        Species_Name.clear();
        Current_Count.clear();

    }


    public void idOnAction(ActionEvent actionEvent) throws SQLException {
        String id = Butterfly_INtrntnl_Variety_ID.getText();

        butterfltDto dto = ButterflyModel.getDetails(id);
        if (dto == null){
            new Alert(Alert.AlertType.ERROR,"Not Found").show();
        } else {
            Variety_Name.setText(dto.getB_Name());
            Avg_lifetime.setText(dto.getAvg_Life_Time());
            Description.setText(dto.getB_Description());
            Species_Name.setText(dto.getSpecies());
            Current_Count.setText(dto.getCurrent_Count());
        }
    }
}
