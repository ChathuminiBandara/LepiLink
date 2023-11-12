package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.employeeDto;
import lombok.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModel {
    public boolean saveEmployee(employeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO employee VALUES(?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEId());
        pstm.setString(2, dto.getEName());
        pstm.setString(3, dto.getTP());
        pstm.setString(4, dto.getStartedDate());
        pstm.setString(5, dto.getESrt());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
