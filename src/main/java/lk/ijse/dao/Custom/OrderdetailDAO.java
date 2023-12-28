package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface OrderdetailDAO extends CrudDAO<CartTm> {
    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException;
     boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException;

    }
