package lk.ijse.dao;

import lk.ijse.dto.employeeDto;

import java.sql.SQLException;

public interface EmployeeDAO {
    boolean updateEmployee(employeeDto dto) throws SQLException;
    boolean deleteEmployee(String id) throws SQLException;
    boolean saveEmployee(employeeDto dto) throws SQLException;

    }
