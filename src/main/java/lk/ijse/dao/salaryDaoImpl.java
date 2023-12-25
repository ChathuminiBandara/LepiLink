package lk.ijse.dao;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;
import lk.ijse.dto.salaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class salaryDaoImpl {
    public static boolean deletePayment(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM salary WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public boolean saveSalary(salaryDto dto) throws SQLException {
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
    public static boolean updateSalary(paymentDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE salary SET paymentId = ?, visitorName = ?, paymentStatus = ?, visitorContactNum = ? ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getPaymentId());
        pstm.setString(2, dto.getVisitorName());
        pstm.setString(3, dto.getPaymentStatus());
        pstm.setString(4, dto.getVisitorContactNum());

        return pstm.executeUpdate() > 0;
    }
}
