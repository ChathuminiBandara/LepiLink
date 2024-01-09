package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDto> getAllSalary() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateCustomerID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public CustomerDto searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
