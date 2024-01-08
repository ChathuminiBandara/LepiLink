package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.salaryDto;

import java.sql.SQLException;

public interface SalaryDAO extends CrudDAO<salaryDto> {
    void delete(String id) throws SQLException;
    boolean save(salaryDto dto) throws SQLException;
    boolean update(salaryDto dto) throws SQLException;
}
