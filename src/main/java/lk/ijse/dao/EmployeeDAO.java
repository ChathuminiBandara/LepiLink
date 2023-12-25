package lk.ijse.dao;

import lk.ijse.dto.employeeDto;

import java.sql.SQLException;

public interface EmployeeDAO {
    static boolean updateEmployee(employeeDto dto) throws SQLException;
    static boolean deleteEmployee(String id) throws SQLException;
    boolean saveEmployee(employeeDto dto) throws SQLException;

    }
