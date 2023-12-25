package lk.ijse.dao.Custom;

import lk.ijse.dao.VisitorDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.visitorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class visitorDaoImpl implements VisitorDAO {

    @Override
    public boolean saveVisitor(visitorDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO visitor VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getVisitorId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getStatus());
        pstm.setString(4, dto.getTime());
        pstm.setString(5, dto.getPStatus());
        pstm.setString(6, dto.getDate());
        pstm.setString(7, dto.getBId());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;

    }

    @Override
    public static boolean deleteVisitor(String intId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM visitor WHERE visitorId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, intId);

        boolean b = pstm.executeUpdate() > 0;
        return b;

    }

    @Override
    public static visitorDto getDetails(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select * from visitor where bId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        visitorDto dto = null;

        if (resultSet.next()){
            dto = new visitorDto();

            dto.setName(resultSet.getString(2));
            dto.setStatus(resultSet.getString(3));
            dto.setTime(resultSet.getString(4));
            dto.setPStatus(resultSet.getString(5));
            dto.setDate(resultSet.getString(6));
            dto.setBId(resultSet.getString(7));

            return dto;
        }

        return dto;

    }

    @Override
    public boolean updateVisitor(visitorDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE visitor SET visitorName=?,status=?,time=?,paymentStatus=?,date=?,bId=? WHERE visitorId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getVisitorId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getStatus());
        pstm.setString(4, dto.getTime());
        pstm.setString(5, dto.getPStatus());
        pstm.setString(6, dto.getDate());
        pstm.setString(6, dto.getBId());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;

    }
}
