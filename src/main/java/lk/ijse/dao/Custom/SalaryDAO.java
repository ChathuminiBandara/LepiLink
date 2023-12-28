package lk.ijse.dao.Custom;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;
import lk.ijse.dto.salaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SalaryDAO {
    boolean deletePayment(String id) throws SQLException;
    boolean saveSalary(salaryDto dto) throws SQLException;
    boolean updateSalary(paymentDto dto) throws SQLException;
}
