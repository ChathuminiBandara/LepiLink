package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.PlaceOrderDto;

import java.sql.SQLException;

public interface PlaceOrderDAO extends CrudDAO {
    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;

    }
