package lk.ijse.dao.custom.impl;

import javafx.scene.control.TextField;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dao.custom.VisitorDAO;
import lk.ijse.entity.salary;
import lk.ijse.entity.visitor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorDaoImpl implements VisitorDAO {
    @Override
    public ArrayList<visitor> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM salary");
        ArrayList<visitor> allvisitor = new ArrayList<>();
        while (rst.next()){
            visitor entity = new visitor(
                    rst.getString("visitorId"),
                    rst.getString("name"),
                    rst.getString("status"),
                    rst.getString("time"),
                    rst.getString("pstatus"),
                    rst.getString("date"),
                    rst.getString("bookingId")
            );
            allvisitor.add(entity);
        }
        return allvisitor;
    }

    @Override
    public boolean save(visitor entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO visitor (visitorId,visitorName,status,time,paymentStatus,date,reservationId)",
                entity.getVisitorId(),entity.getVisitorName(),entity.getStatus(),entity.getTime(),entity.getPaymentStatus(),entity.getDate(),entity.getReservationId());
    }

    @Override
    public boolean update(visitor entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE salary SET visitorName=?,status=?,time=?,paymentStatus=?,date=?,reservationID=? WHERE visitorId= ?",
                entity.getVisitorId(),entity.getVisitorName(),entity.getStatus(),entity.getTime(),entity.getPaymentStatus(),entity.getDate(),entity.getReservationId());
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT visitorId FROM visitor WHERE visitorId=?",id);
        return rst.next();
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM visitor WHERE visitorId=?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM salary ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newVisitor = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newVisitor);
        } else {
            return "C00-001";
        }
    }

    @Override
    public visitor search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM salary WHERE sId=?",id);
        rst.next();
        return new visitor(id + "", rst.getString("visitorId"), rst.getString("visitorName"),rst.getString("time"),rst.getString("paymentStatus"),rst.getString("date"),rst.getString("reservationId"));
    }
}
