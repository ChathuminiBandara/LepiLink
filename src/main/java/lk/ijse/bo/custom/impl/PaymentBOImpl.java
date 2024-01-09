package lk.ijse.bo.custom.impl;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.PayBO;
import lk.ijse.dto.paymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PayBO {
    @Override
    public ArrayList<paymentDto> getAllPay() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean savePay(paymentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updatePay(paymentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existPay(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void deletePay(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generatePayID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public paymentDto searchPay(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
