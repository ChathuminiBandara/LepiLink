package lk.ijse.dao;

import lk.ijse.dto.empScheduleDto;

import java.sql.SQLException;

public interface EmpScheduleDAO {
    public boolean saveEmployeeSchedule(empScheduleDto dto) throws SQLException;

    }
