package lk.ijse.dao.custom.impl;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.dto.salaryDto;
import lk.ijse.entity.item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDAO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<item> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(item dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(item dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public item search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
