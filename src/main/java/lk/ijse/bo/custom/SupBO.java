package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.salaryDto;
import lk.ijse.dto.supplierDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupBO extends SuperBO {
    ArrayList<supplierDto> getAllSup() throws SQLException, ClassNotFoundException;
    boolean saveSup(supplierDto dto) throws SQLException, ClassNotFoundException;
    boolean updateSup(supplierDto dto) throws SQLException, ClassNotFoundException;
    boolean existSup(String id) throws SQLException, ClassNotFoundException;
    void deleteSup(String id) throws SQLException, ClassNotFoundException;
    String generateSupID() throws SQLException, ClassNotFoundException;
    supplierDto searchSup(String id) throws SQLException, ClassNotFoundException;
}
