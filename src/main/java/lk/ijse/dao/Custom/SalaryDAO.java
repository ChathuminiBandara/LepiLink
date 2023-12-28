package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.paymentDto;
import lk.ijse.dto.salaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SalaryDAO extends CrudDAO<salaryDto> {
    boolean delete(String id) throws SQLException;
    boolean save(salaryDto dto) throws SQLException;
    boolean update(salaryDto dto) throws SQLException;
}
