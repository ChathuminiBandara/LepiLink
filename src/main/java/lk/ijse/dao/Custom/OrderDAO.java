package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.PlaceOrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<PlaceOrderDto> {
    String generateNextOrderId() throws SQLException;
   // private String splitOrderId(String currentOrderId);
    boolean save(PlaceOrderDto dto) throws SQLException;

   // boolean save(String orderId, String customerId, LocalDate date) throws SQLException;
}
