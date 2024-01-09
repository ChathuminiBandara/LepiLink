package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.salaryDto;
import lk.ijse.dto.visitorDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VisitorBO extends SuperBO {
    ArrayList<visitorDto> getAllVisitor() throws SQLException, ClassNotFoundException;
    boolean saveVisitor(visitorDto dto) throws SQLException, ClassNotFoundException;
    boolean updateVisitor(visitorDto dto) throws SQLException, ClassNotFoundException;
    boolean existVisitor(String id) throws SQLException, ClassNotFoundException;
    void deleteVisitor(String id) throws SQLException, ClassNotFoundException;
    String generateVisitorID() throws SQLException, ClassNotFoundException;
    visitorDto searchVisitor(String id) throws SQLException, ClassNotFoundException;
}
