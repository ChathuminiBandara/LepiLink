package lk.ijse.dao;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PaymentDAO {
    static boolean updatePayment(paymentDto dto) throws SQLException;
    static boolean deletePayment(String id) throws SQLException;
    boolean savePayment(paymentDto dto) throws SQLException;
}
