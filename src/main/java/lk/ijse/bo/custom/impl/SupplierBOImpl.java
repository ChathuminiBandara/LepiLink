package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.SupBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.SupDAO;
import lk.ijse.dto.salaryDto;
import lk.ijse.dto.supplierDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupBO {
SupDAO supDAO = (SupDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    @Override
    public ArrayList<supplierDto> getAllSup() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveSup(supplierDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateSup(supplierDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existSup(String id) throws SQLException, ClassNotFoundException {
        return supDAO.exist(id);    }

    @Override
    public void deleteSup(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateSupID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public supplierDto searchSup(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

}
