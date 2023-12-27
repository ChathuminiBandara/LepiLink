package lk.ijse.dao.Custom;

import lk.ijse.dao.ButterflyDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.butterfltDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ButterflyDaoImpl implements ButterflyDAO {

    @Override
    public  butterfltDto getDetails(String id) throws SQLException {

            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "select * from butterflyvariety where bId=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();

            butterfltDto dto = null;

            if (resultSet.next()){
                dto = new butterfltDto();

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

    @Override
    public  boolean deleteButterfly(String intId) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM butterflyvariety WHERE bId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, intId);

        boolean b = pstm.executeUpdate() > 0;
        return b;
    }

    @Override
    public boolean saveButterfly(butterfltDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO butterflyvariety VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getBId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getDesc());
        pstm.setString(4, dto.getSpecies());
        pstm.setString(5, dto.getLifeTime());
        pstm.setString(6, dto.getCount());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;


    }

    @Override
    public boolean updateButterfly(butterfltDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE butterflyvariety SET name=?,description=?,species=?,avgLifeTime=?,currentCount=? WHERE bId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getBId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getDesc());
        pstm.setString(4, dto.getSpecies());
        pstm.setString(5, dto.getLifeTime());
        pstm.setString(6, dto.getCount());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;

    }
}
