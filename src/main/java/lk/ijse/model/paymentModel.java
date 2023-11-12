package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class paymentModel {
        public boolean savePayment(paymentDto dto) throws SQLException {
            Connection connection = DbConnection.getInstance().getConnection();

            String sql = "INSERT INTO payment VALUES(?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, dto.getPaymentId());
            pstm.setString(2, dto.getVisitorName());
            pstm.setString(3, dto.getPaymentStatus());
            pstm.setString(4, dto.getVisitorContactNum());
            pstm.setString(5, dto.getReservationId());


            boolean isSaved = pstm.executeUpdate() > 0;
            return isSaved;


        }
}
