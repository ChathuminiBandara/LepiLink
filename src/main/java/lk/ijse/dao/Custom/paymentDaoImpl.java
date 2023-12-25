package lk.ijse.dao.Custom;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class paymentDaoImpl {
    public static boolean updatePayment(paymentDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET paymentId = ?, visitorName = ?, paymentStatus = ?, visitorContactNum = ? ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getPaymentId());
        pstm.setString(2, dto.getVisitorName());
        pstm.setString(3, dto.getPaymentStatus());
        pstm.setString(4, dto.getVisitorContactNum());

        return pstm.executeUpdate() > 0;
    }

    public static boolean deletePayment(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public boolean savePayment(paymentDto dto) throws SQLException {
            Connection connection = DbConnection.getInstance().getConnection();

            String sql = "INSERT INTO payment VALUES(?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, dto.getPaymentId());
            pstm.setString(2, dto.getVisitorName());
            pstm.setString(3, dto.getPaymentStatus());
            pstm.setString(4, dto.getVisitorContactNum());


            boolean isSaved = pstm.executeUpdate() > 0;
            return isSaved;


        }
}
