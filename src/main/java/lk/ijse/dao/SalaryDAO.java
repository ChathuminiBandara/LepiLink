package lk.ijse.dao;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;
import lk.ijse.dto.salaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SalaryDAO {
    public static boolean deletePayment(String id) throws SQLException;
    boolean saveSalary(salaryDto dto) throws SQLException;
    static boolean updateSalary(paymentDto dto) throws SQLException;
}
