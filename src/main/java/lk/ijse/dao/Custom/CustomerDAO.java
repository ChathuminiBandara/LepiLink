package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<CustomerDto> {
    boolean update(CustomerDto dto) throws SQLException;
    void delete(String id) throws SQLException;

    List<CustomerDto> getAllCustomer() throws SQLException;

    boolean save(CustomerDto dto) throws SQLException;

    CustomerDto searchCustomer(String id) throws SQLException;

    }
