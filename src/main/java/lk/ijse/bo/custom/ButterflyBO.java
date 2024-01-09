package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.butterflyDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ButterflyBO extends SuperBO {
    ArrayList<butterflyDto> getAllButterfly() throws SQLException, ClassNotFoundException;
    boolean saveButterfly(butterflyDto dto) throws SQLException, ClassNotFoundException;
    boolean updateButterfly(butterflyDto dto) throws SQLException, ClassNotFoundException;
    boolean existButterfly(String id) throws SQLException, ClassNotFoundException;
    void deleteButterfly(String id) throws SQLException, ClassNotFoundException;
    String generateButterflyID() throws SQLException, ClassNotFoundException;
    butterflyDto searchButterfly(String id) throws SQLException, ClassNotFoundException;
}
