package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ButterflyDAO;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.dto.butterflyDto;
import lk.ijse.dto.salaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ButterflyBOImpl implements SuperBO {
    ButterflyDAO butterflyDAO = (ButterflyDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BUTTERFLY);
    @Override
    public ArrayList<butterflyDto> getAllButterfly() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveButterfly(butterflyDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateButterfly(butterflyDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existButterfly(String id) throws SQLException, ClassNotFoundException {
        return butterflyDAO.exist(id);    }

    @Override
    public void deleteButterfly(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateButterflyID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public butterflyDto searchButterfly(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
