package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.empScheduleDto;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

public interface EmpScheduleDAO extends CrudDAO<empScheduleDto> {
    public boolean save(empScheduleDto dto) throws SQLException;

    }
