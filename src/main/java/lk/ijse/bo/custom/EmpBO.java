package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.employeeDto;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpBO extends SuperBO {
    ArrayList<employeeDto> getAllEmp() throws SQLException, ClassNotFoundException;
    boolean saveEmp(employeeDto dto) throws SQLException, ClassNotFoundException;
    boolean updateEmp(employeeDto dto) throws SQLException, ClassNotFoundException;
    boolean existEmp(String id) throws SQLException, ClassNotFoundException;
    void deleteEmp(String id) throws SQLException, ClassNotFoundException;
    String generateEmpID() throws SQLException, ClassNotFoundException;
    employeeDto searchEmp(String id) throws SQLException, ClassNotFoundException;
}
