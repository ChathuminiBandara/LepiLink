package lk.ijse.model;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.butterfltDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ButterflyModel {
    public static butterfltDto getDetails(String id) throws SQLException {

            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "select * from butterflyvariety where bId=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();

            butterfltDto dto = null;

            if (resultSet.next()){
                dto = new butterfltDto();

                dto.setB_Id(resultSet.getString(1));
                dto.setB_Name(resultSet.getString(2));
                dto.setB_Description(resultSet.getString(3));
                dto.setSpecies(resultSet.getString(4));
                dto.setAvg_Life_Time(resultSet.getString(5));
                dto.setCurrent_Count(resultSet.getString(6));

                return dto;
            }



        return dto;

    }

    public static boolean deleteButterfly(String intId) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM butterflyvariety WHERE bId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, intId);

        boolean b = pstm.executeUpdate() > 0;
        return b;
    }

    public boolean saveButterfly(butterfltDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO butterflyvariety VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getB_Id());
        pstm.setString(2, dto.getB_Name());
        pstm.setString(3, dto.getB_Description());
        pstm.setString(4, dto.getSpecies());
        pstm.setString(5, dto.getAvg_Life_Time());
        pstm.setString(6, dto.getCurrent_Count());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;


    }

    public boolean updateButterfly(butterfltDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE butterflyvariety SET name=?,description=?,species=?,avgLifeTime=?,currentCount=? WHERE bId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getB_Name());
        pstm.setString(2, dto.getB_Description());
        pstm.setString(3, dto.getSpecies());
        pstm.setString(4, dto.getAvg_Life_Time());
        pstm.setString(5, dto.getCurrent_Count());
        pstm.setString(6, dto.getB_Id());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;

    }
}
