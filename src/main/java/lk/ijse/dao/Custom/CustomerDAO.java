package lk.ijse.dao.Custom;

import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    boolean updateCustomer(CustomerDto dto) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;

    List<CustomerDto> getAllCustomer() throws SQLException;

    boolean saveCustomer(CustomerDto dto) throws SQLException;

    CustomerDto searchCustomer(String id) throws SQLException;

    }
