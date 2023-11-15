package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.salaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class salaryModel {
    public boolean saveSalary(salaryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO salary VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getSId());
        pstm.setString(2, dto.getStatus());
        pstm.setString(3, dto.getAmount());
        pstm.setString(4, dto.getEmpId());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;


    }
}
