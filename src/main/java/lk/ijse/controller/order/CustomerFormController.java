package lk.ijse.controller.order;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.tm.CustomerTm;
import lk.ijse.dao.Custom.CustomerDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerFormController {
    public AnchorPane root;
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    private CustomerDaoImpl cusModel = new CustomerDaoImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllCustomer();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void loadAllCustomer() {
        var model = new CustomerDaoImpl();

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList = model.getAllCustomer();

            for (CustomerDto dto : dtoList) {
                obList.add(
                        new CustomerTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getAddress(),
                                dto.getTel()
                        )
                );
            }

            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (validateFields()) {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String tel = txtTel.getText();

            var dto = new CustomerDto(id, name, address, tel);

            try {
                boolean isSaved = cusModel.saveCustomer(dto);

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer saved!").show();
                    clearFields();
                    loadAllCustomer(); // Reload the table after saving
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = cusModel.deleteCustomer(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer deleted!").show();
                loadAllCustomer(); // Reload the table after deleting
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer not deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (validateFields()) {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String tel = txtTel.getText();

            var dto = new CustomerDto(id, name, address, tel);

            try {
                boolean isUpdated = cusModel.updateCustomer(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer updated!").show();
                    clearFields();
                    loadAllCustomer(); // Reload the table after updating
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            CustomerDto customerDto = cusModel.searchCustomer(id);
            if (customerDto != null) {
                txtId.setText(customerDto.getId());
                txtName.setText(customerDto.getName());
                txtAddress.setText(customerDto.getAddress());
                txtTel.setText(customerDto.getTel());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Customer not found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
    }

    public void backOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    private boolean validateFields() {
        if (txtId.getText().isEmpty() || txtName.getText().isEmpty() ||
                txtAddress.getText().isEmpty() || txtTel.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all fields").show();
            return false;
        }

        // Add more specific validation as needed

        return true;
    }
}

