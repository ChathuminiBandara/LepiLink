package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.SalaryDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.salaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class salaryDaoImpl implements SalaryDAO {
    @Override
    public void delete(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM salary WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean save(salaryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO salary VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getSId());
        pstm.setString(2, dto.getStatus());
        pstm.setString(3, dto.getAmount());
        pstm.setString(4, dto.getEmpId());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    @Override
    public  boolean update(salaryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE salary SET sId = ?, status = ?, amount = ?, empId = ? ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getAmount());
        pstm.setString(2, dto.getEmpId());
        pstm.setString(3, dto.getStatus());
        pstm.setString(4, dto.getSId());

        return pstm.executeUpdate() > 0;
    }
}
