package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO {

    public String getCurrentOrderId() throws SQLException, ClassNotFoundException;

    public boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException;

    public boolean placeOrder(OrderDTO orderDTO)throws SQLException, ClassNotFoundException;















}
