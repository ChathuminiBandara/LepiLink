package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.butterflyDto;
import lk.ijse.entity.butterflyvariety;

import java.sql.SQLException;

public interface ButterflyDAO extends CrudDAO<butterflyDto> {
     butterflyDto getDetails(String id) throws SQLException;
     void delete(String intId) throws SQLException, ClassNotFoundException;
    boolean save(butterflyvariety entity) throws SQLException, ClassNotFoundException;
    boolean update(butterflyvariety entity ) throws SQLException, ClassNotFoundException;
    boolean exist(String id) throws  SQLException;
}
