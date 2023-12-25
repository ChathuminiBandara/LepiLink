package lk.ijse.dao;

import lk.ijse.dto.ItemDto;
import lk.ijse.dto.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    boolean deleteItem(String code) throws SQLException;
    boolean saveItem(ItemDto dto) throws SQLException;
    List<ItemDto> loadAllItems() throws SQLException;
    ItemDto searchItem(String code) throws SQLException;
    boolean updateItem(ItemDto itemDto) throws SQLException;
    boolean updateItem(List<CartTm> cartTmList) throws SQLException;
    boolean updateQty(String code, int qty) throws SQLException;

    }
