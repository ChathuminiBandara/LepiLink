package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.employeeDto;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<employeeDto> {
    boolean update(employeeDto dto) throws SQLException;
    boolean delete(String id) throws SQLException;
    boolean save(employeeDto dto) throws SQLException;

    }
