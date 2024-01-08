package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.EmployeeDAO;
import lk.ijse.dao.SQLutill;
import lk.ijse.entity.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public ArrayList<employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutill.execute("SELECT * FROM employee");
        ArrayList<employee> allEmployee = new ArrayList<>();

        while(rst.next()){
            employee entity = new employee(
                    rst.getString("id"),
                    rst.getString("eName"),
                    rst.getString("contact"),
                    rst.getString("startedDate"),
                    rst.getString("eSrt"));
                allEmployee.add(entity);
        }
        return allEmployee;
    }
    @Override
    public boolean update(employee entity) throws SQLException,ClassNotFoundException {
        return SQLutill.execute("UPDATE employee SET eName=?,contact=?.startedDate=?,eSrt=? WHERE id =?",
                entity.geteName(),entity.geteSrt(),entity.getContact(),entity.getStartedDate());
    }
       /* Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE employee SET eId = ?, eName = ?, contact = ?, startedDate = ? WHERE eSrt = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEId());
        pstm.setString(2, dto.getEName());
        pstm.setString(3, dto.getTP());
        pstm.setString(4, dto.getStartedDate());
        pstm.setString(5, dto.getESrt());
        return pstm.executeUpdate() > 0;

    }*/

    @Override
    public void delete(String id) throws SQLException , ClassNotFoundException {
        SQLutill.execute("DELETE employee WHERE eId=?", id);
        return false;
    }
    /*
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM employee WHERE eId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);
        return pstm.executeUpdate() > 0;
    }*/

    @Override
    public boolean save(employee entity) throws SQLException , ClassNotFoundException {
        return SQLutill.execute("INSERT INTO employee (eId,eName,contact,startedDate,eSrt) VALUES(?,?,?,?,?)",
                entity.geteId(), entity.geteName(), entity.getContact(), entity.getStartedDate(), entity.geteSrt());
    }

       /* Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO employee VALUES(?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEId());
        pstm.setString(2, dto.getEName());
        pstm.setString(3, dto.getTP());
        pstm.setString(4, dto.getStartedDate());
        pstm.setString(5, dto.getESrt());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }*/
}
