package lk.ijse.dao;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.butterfltDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ButterflyDAO extends CrudDAO<butterfltDto>{
     butterfltDto getDetails(String id) throws SQLException;
     boolean delete(String intId) throws SQLException;
    boolean save(butterfltDto dto) throws SQLException;
    boolean update(butterfltDto dto) throws SQLException;
}
