package lk.ijse.dao.Custom;

import lk.ijse.dao.PlaceOrderDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.PlaceOrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderDaoImpl implements PlaceOrderDAO {
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    private ItemDaoImpl itemDaoImpl = new ItemDaoImpl();
    private OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();


    @Override
    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
        System.out.println(placeOrderDto);

        String orderId = placeOrderDto.getOrderId();
        String customerId = placeOrderDto.getCustomerId();
        LocalDate date = placeOrderDto.getDate();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderDaoImpl.saveOrder(orderId, customerId, date);
            if (isOrderSaved) {
                boolean isUpdated = itemDaoImpl.updateItem(placeOrderDto.getCartTmList());
                if (isUpdated) {
                    boolean isOrderDetailSaved = orderDetailDaoImpl.saveOrderDetails(placeOrderDto.getOrderId(), placeOrderDto.getCartTmList());
                    if (isOrderDetailSaved) {
                        connection.commit();
                    }
                }
            }
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return true;
    }
}
