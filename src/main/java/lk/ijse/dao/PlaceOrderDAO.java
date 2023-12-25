package lk.ijse.dao;

import lk.ijse.dto.PlaceOrderDto;

import java.sql.SQLException;

public interface PlaceOrderDAO {
    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;

    }
