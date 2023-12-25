package lk.ijse.dao;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.supplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SupplierDAO {
    static boolean deleteSupplier(String id) throws SQLException;
    static boolean updateSupplier(supplierDto dto) throws SQLException;
    boolean saveSupplier(supplierDto dto) throws SQLException;
}
