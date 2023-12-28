package lk.ijse.dao.Custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<ItemDto> {
    boolean delete(String code) throws SQLException;
    boolean save(ItemDto dto) throws SQLException;
    List<ItemDto> loadAllItems() throws SQLException;
    ItemDto searchItem(String code) throws SQLException;
    boolean update(ItemDto itemDto) throws SQLException;
    boolean update(List<CartTm> cartTmList) throws SQLException;
    boolean updateQty(String code, int qty) throws SQLException;

    }
