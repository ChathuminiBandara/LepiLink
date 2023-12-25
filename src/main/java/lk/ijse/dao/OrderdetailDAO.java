package lk.ijse.dao;

import lk.ijse.dto.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface OrderdetailDAO {
    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException;
    private boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException;

    }
