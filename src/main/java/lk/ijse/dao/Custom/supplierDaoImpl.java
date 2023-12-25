package lk.ijse.dao.Custom;

import lk.ijse.dao.SupplierDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.supplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class supplierDaoImpl implements SupplierDAO {

    @Override
    public static boolean deleteSupplier(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    @Override
    public static boolean updateSupplier(supplierDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE supplier SET supplierName = ?, supplierCompanyName = ?, dateSupplied = ?, qtySupplied = ? WHERE supplierId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getSupplierName());
        pstm.setString(2, dto.getSupplierCompanyName());
        pstm.setString(3, dto.getDateSupplied());
        pstm.setString(4, dto.getQtySupplied());
        pstm.setString(5, dto.getSupplierId());

        return  pstm.executeUpdate() > 0;
    }

    @Override
    public  boolean saveSupplier(supplierDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO supplier VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getSupplierId());
        pstm.setString(2, dto.getSupplierName());
        pstm.setString(3, dto.getSupplierCompanyName());
        pstm.setString(4, dto.getDateSupplied());
        pstm.setString(5, dto.getQtySupplied());
        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;
    }
}
