package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;

    public void deleteItem(String code) throws SQLException, ClassNotFoundException ;

    public void saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException ;

    public void updateItem(String code, String description, BigDecimal unitPrice,int qtyOnHand) throws SQLException, ClassNotFoundException ;

    public boolean existsItem(String code) throws SQLException, ClassNotFoundException ;

    public String itemCode() throws SQLException, ClassNotFoundException;


    public ItemDTO findItemData(String code) throws SQLException, ClassNotFoundException;

    public ItemDTO searchItems(String newItemCode) throws SQLException, ClassNotFoundException;

    public boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand, Connection connection) throws SQLException;
}