package lk.ijse.dao;

import lk.ijse.dto.paymentDto;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO {
    boolean update(T dto) throws SQLException;
    boolean delete(String id) throws SQLException;
    boolean save(T dto) throws SQLException;
}
