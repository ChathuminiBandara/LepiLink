package lk.ijse.bo.Custom;

import javafx.event.ActionEvent;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;

public interface CustomerBO /*extends SuperBO*/ {
    boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    void saveCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException;

}
