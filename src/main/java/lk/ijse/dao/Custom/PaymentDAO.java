package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.paymentDto;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<paymentDto> {
     boolean update(paymentDto dto) throws SQLException;
     void delete(String id) throws SQLException;
    boolean save(paymentDto dto) throws SQLException;
}
