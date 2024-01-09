package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.paymentDto;
import lk.ijse.dto.salaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PayBO extends SuperBO {
    ArrayList<paymentDto> getAllPay() throws SQLException, ClassNotFoundException;
    boolean savePay(paymentDto dto) throws SQLException, ClassNotFoundException;
    boolean updatePay(paymentDto dto) throws SQLException, ClassNotFoundException;
    boolean existPay(String id) throws SQLException, ClassNotFoundException;
    void deletePay(String id) throws SQLException, ClassNotFoundException;
    String generatePayID() throws SQLException, ClassNotFoundException;
    paymentDto searchPay(String id) throws SQLException, ClassNotFoundException;
}
