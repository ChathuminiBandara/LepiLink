package lk.ijse.dao.Custom;

import lk.ijse.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    String generateNextOrderId() throws SQLException;
   // private String splitOrderId(String currentOrderId);
    boolean saveOrder(String orderId, String customerId, LocalDate date) throws SQLException;
}
