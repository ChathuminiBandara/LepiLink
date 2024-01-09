package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.VisitorBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.VisitorDAO;
import lk.ijse.dto.salaryDto;
import lk.ijse.dto.visitorDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VisitoBOImpl implements VisitorBO {
    VisitorDAO visitorDAO = (VisitorDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VISITOR);
    @Override
    public ArrayList<visitorDto> getAllVisitor() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveVisitor(visitorDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateVisitor(visitorDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existVisitor(String id) throws SQLException, ClassNotFoundException {
        return visitorDAO.exist(id);    }

    @Override
    public void deleteVisitor(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateVisitorID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public visitorDto searchVisitor(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
