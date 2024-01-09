package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.EmpBO;
import lk.ijse.dto.employeeDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmpBO {
    @Override
    public ArrayList<employeeDto> getAllEmp() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveEmp(employeeDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateEmp(employeeDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existEmp(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void deleteEmp(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateEmpID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public employeeDto searchEmp(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
