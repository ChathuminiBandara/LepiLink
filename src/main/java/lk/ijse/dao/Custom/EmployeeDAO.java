package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<employee> {
    ArrayList<employee> getAll() throws SQLException, ClassNotFoundException;
    boolean update(employee dto) throws SQLException, ClassNotFoundException;
    void delete(String id) throws SQLException, ClassNotFoundException;
    boolean save(employee dto) throws SQLException, ClassNotFoundException;

    }
