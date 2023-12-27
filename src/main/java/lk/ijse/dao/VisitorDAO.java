package lk.ijse.dao;

import lk.ijse.dto.visitorDto;

import java.sql.SQLException;

public interface VisitorDAO {
    boolean saveVisitor(visitorDto dto) throws SQLException;
    boolean deleteVisitor(String visitorId) throws SQLException;
    visitorDto getDetails(String id) throws SQLException;
    boolean updateVisitor(visitorDto dto) throws SQLException;
}
