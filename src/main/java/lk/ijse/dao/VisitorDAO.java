package lk.ijse.dao;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.visitorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface VisitorDAO {
    boolean saveVisitor(visitorDto dto) throws SQLException;
    static boolean deleteVisitor(String intId) throws SQLException;
    static visitorDto getDetails(String id) throws SQLException;
    boolean updateVisitor(visitorDto dto) throws SQLException;
}
