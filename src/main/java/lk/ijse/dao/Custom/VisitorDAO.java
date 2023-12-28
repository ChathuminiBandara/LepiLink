package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.visitorDto;

import java.sql.SQLException;

public interface VisitorDAO extends CrudDAO<visitorDto> {
    boolean save(visitorDto dto) throws SQLException;
    boolean delete(String visitorId) throws SQLException;
    visitorDto getDetails(String id) throws SQLException;
    boolean update(visitorDto dto) throws SQLException;
}
