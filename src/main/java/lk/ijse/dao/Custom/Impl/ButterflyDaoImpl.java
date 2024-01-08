package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.ButterflyDAO;
import lk.ijse.dao.SQLutill;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.butterflyDto;
import lk.ijse.entity.butterflyvariety;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ButterflyDaoImpl implements ButterflyDAO {

    @Override
    public void delete(String intId) throws SQLException, ClassNotFoundException {
        SQLutill.execute("DELETE FROM butterflyvariety WHERE bId =?",intId);
    }

    @Override
    public boolean save(butterflyvariety entity) throws SQLException ,ClassNotFoundException{
        return SQLutill.execute("INSERT INTO butterflyvariety (bId,name,description,species,avgLifetime,currentCount) VALUES (?,?,?,?,?,?)",
                entity.getbId(),entity.getName(),entity.getAvgLifetime(),entity.getDesc());
    }

    @Override
    public ArrayList<butterflyDto> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutill.execute("SELECT * FROM butterflyvariety");
        ArrayList<butterflyvariety> allButterfly = new ArrayList<>();
        while (rst.next()) {
            butterflyvariety entity = new butterflyvariety(
                    rst.getString("bId"),
                    rst.getString("name"),
                    rst.getString("description"),
                    rst.getString("species"),
                    rst.getString("avgLifeTime"),
                    rst.getString("currentCount"));
            allButterfly.add(entity);
        }
        return null;
    }
    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutill.execute("SELECT id FROM butterflyvariety ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newBtID = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newBtID );
        } else {
            return "C00-001";
        }
    }

    @Override
    public butterflyvariety search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutill.execute("SELECT * FROM butterflyvariety WHERE bId=?",id);
        rst.next();
        return new butterflyvariety(id + "", rst.getString("name"), rst.getString("description"));
    }

    @Override
    public boolean update(butterflyDto entity) throws SQLException, ClassNotFoundException {
        return SQLutill.execute("UPDATE butterflyvariety SET name=?,description=?,species=?,avgLifeTime=?,currentCount=? WHERE bId=?",
                entity.getBId(),entity.getName(),entity.getSpecies(),entity.getDesc(),entity.getCount(),entity.getLifeTime());

    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public butterflyDto getDetails(String id) throws SQLException {

            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "select * from butterflyvariety where bId=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();

            butterflyDto dto = null;

            if (resultSet.next()){
                dto = new butterflyDto();

                dto.setBId(resultSet.getString(1));
                dto.setName(resultSet.getString(2));
                dto.setDesc(resultSet.getString(3));
                dto.setSpecies(resultSet.getString(4));
                dto.setLifeTime(resultSet.getString(5));
                dto.setCount(resultSet.getString(6));

                return dto;
            }

        return dto;

    }
}
