package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.Custom.CustomerDAO;
import lk.ijse.dao.DAOFactory;

public class CustomerBOImpl extends SuperBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

}
