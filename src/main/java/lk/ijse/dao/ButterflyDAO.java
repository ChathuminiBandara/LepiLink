package lk.ijse.dao;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.butterfltDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ButterflyDAO {
    static butterfltDto getDetails(String id) throws SQLException;
    static boolean deleteButterfly(String intId) throws SQLException;
    boolean saveButterfly(butterfltDto dto) throws SQLException;
    boolean updateButterfly(butterfltDto dto) throws SQLException;
}
