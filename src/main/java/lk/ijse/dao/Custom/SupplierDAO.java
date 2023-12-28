package lk.ijse.dao.Custom;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.supplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SupplierDAO {
    boolean delete(String id) throws SQLException;
    boolean update(supplierDto dto) throws SQLException;
    boolean save(supplierDto dto) throws SQLException;
}
