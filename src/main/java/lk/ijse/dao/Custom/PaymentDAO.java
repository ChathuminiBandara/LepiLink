package lk.ijse.dao.Custom;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PaymentDAO {
     boolean updatePayment(paymentDto dto) throws SQLException;
     boolean deletePayment(String id) throws SQLException;
    boolean savePayment(paymentDto dto) throws SQLException;
}
