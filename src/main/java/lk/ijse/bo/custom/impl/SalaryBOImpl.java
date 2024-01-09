package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SalaryBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.dto.salaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBOImpl implements SalaryBO {

    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);
    @Override
    public ArrayList<salaryDto> getAllSalary() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveSalary(salaryDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateSalary(salaryDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existSalary(String id) throws SQLException, ClassNotFoundException {
        return salaryDAO.exist(id);    }

    @Override
    public void deleteSalary(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateSalaryID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public salaryDto searchSalary(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
