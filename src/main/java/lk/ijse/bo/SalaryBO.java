package lk.ijse.bo;

import lk.ijse.dto.salaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryBO extends SuperBO{
    ArrayList<salaryDto> getAllSalary() throws SQLException, ClassNotFoundException;
    boolean saveSalary(salaryDto dto) throws SQLException, ClassNotFoundException;
    boolean updateSalary(salaryDto dto) throws SQLException, ClassNotFoundException;
    boolean existSalary(String id) throws SQLException, ClassNotFoundException;
    void deleteSalary(String id) throws SQLException, ClassNotFoundException;
    String generateSalaryID() throws SQLException, ClassNotFoundException;
    salaryDto searchSalary(String id) throws SQLException, ClassNotFoundException;
}
