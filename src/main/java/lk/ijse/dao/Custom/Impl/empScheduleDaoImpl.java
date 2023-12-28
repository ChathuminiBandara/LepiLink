package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.EmpScheduleDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.empScheduleDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class empScheduleDaoImpl implements EmpScheduleDAO {

    @Override
    public boolean saveEmployeeSchedule(empScheduleDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO schedule VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getScheduleId());
        pstm.setString(2, dto.getSupervisor());
        pstm.setString(3, dto.getScheduleLocation());
        pstm.setString(4, dto.getDate());
        pstm.setString(5, dto.getEmpId());
        pstm.setString(6, dto.getDescription());
        pstm.setString(6, dto.getScheduleNote());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

}
