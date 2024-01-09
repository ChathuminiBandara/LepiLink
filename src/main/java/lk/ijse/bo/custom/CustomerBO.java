package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.salaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDto> getAllSalary() throws SQLException, ClassNotFoundException;
    boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    String generateCustomerID() throws SQLException, ClassNotFoundException;
    CustomerDto searchCustomer(String id) throws SQLException, ClassNotFoundException;
}
