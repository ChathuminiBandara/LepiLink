package lk.ijse.bo.Custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.employeeDto;
import lk.ijse.entity.employee;
import java.util.ArrayList;
import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    boolean update(employeeDto dto) throws SQLException, ClassNotFoundException;
    ArrayList<employeeDto> getAllEmployee() throws SQLException,ClassNotFoundException;



    }
