package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SalaryDAO;
import lk.ijse.entity.salary;

import java.sql.*;
import java.util.*;

public class SalaryDAOImpl implements SalaryDAO {

    @Override
    public ArrayList<salary> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM salary");
        ArrayList<salary> allSalary = new ArrayList<>();
        while (rst.next()){
            salary entity = new salary(
                    rst.getString("sId"),
                    rst.getString("status"),
                    rst.getString("amount"),
                    rst.getString("empId")
            );
            allSalary.add(entity);
        }
        return allSalary;
    }

    @Override
    public boolean save(salary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO salary (sId,status,amount,empId) VALUES (?,?,?,?)",
                entity.getsId(),entity.getStatus(),entity.getStatus(),entity.getEmpId());
    }

    @Override
    public boolean update(salary entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE salary SET status=?,amount=? WHERE sId=?",
                entity.getsId(),entity.getStatus(),entity.getAmount(),entity.getEmpId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT sId FROM salary WHERE sId=?",id);
        return rst.next();
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM salary ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newSalaryId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newSalaryId);
        } else {
            return "C00-001";
        }    }

    @Override
    public salary search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM salary WHERE sId=?",id);
        rst.next();
        return new salary(id + "", rst.getString("sId"), rst.getString("amount"),rst.getString("empId"));
    }
}
