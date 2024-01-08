package lk.ijse.bo.Custom;

import javafx.event.ActionEvent;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.butterflyDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ButterflyBO extends SuperBO {
    public void saveButterfly(butterflyDto dto) throws SQLException, CloneNotSupportedException;
    ArrayList<butterflyDto> getAllButterfly() throws SQLException, ClassNotFoundException;
    boolean updateButterfly (butterflyDto dto) throws SQLException, ClassNotFoundException;

    boolean existButterfly(String id) throws SQLException, ClassNotFoundException;

    void deleteButterfly(String id) throws SQLException, ClassNotFoundException;
    String generateCustomerID() throws SQLException, ClassNotFoundException;

}
