package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dao.custom.ButterflyDAO;
import lk.ijse.entity.butterflyvariety;
import lk.ijse.entity.salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ButterflyDAOImpl implements ButterflyDAO {
    @Override
    public ArrayList<butterflyvariety> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM butterflyvariety");
        ArrayList<butterflyvariety> allButterfly = new ArrayList<>();
        while (rst.next()){
            butterflyvariety entity = new butterflyvariety(
                    rst.getString("bId"),
                    rst.getString("name"),
                    rst.getString("desc"),
                    rst.getString("species"),
                    rst.getString("avgLifetime"),
                    rst.getString("currentCount")
            );
            allButterfly.add(entity);
        }
        return allButterfly;    }

    @Override
    public boolean save(butterflyvariety entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO butterflyvariety (bId,name,desc,species,avgLifetime,currentCount) VALUES (?,?,?,?,?,?)",
                entity.getbId(),entity.getName(),entity.getDesc(),entity.getAvgLifetime(),entity.getCurrentCount());
    }

    @Override
    public boolean update(butterflyvariety entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE butterflyvariety SET name=?,desc=?,species=?,avgLifetime=?,currentCount=? WHERE bId=?",
                entity.getbId(),entity.getName(),entity.getDesc(),entity.getAvgLifetime(),entity.getCurrentCount());

    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT bId FROM butterflyvariety WHERE bId=?",id);
        return rst.next();    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM butterflyvariety WHERE bId=?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM butterflyvariety ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newButterflyId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newButterflyId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public butterflyvariety search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM butterflyvariety WHERE sId=?",id);
        rst.next();
        return new butterflyvariety(id + "", rst.getString("name"),rst.getString("desc"),rst.getString("species"),
                rst.getString("avgLifetime"),rst.getString("getCurrentCount"));
    }
}
