package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ArrayList<ItemDTO> allItems = new ArrayList<>();


        while (rst.next()) {
            ItemDTO itemDTO= new ItemDTO(rst.getString("code"), rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand") );
            allItems.add(itemDTO);

        }

        return allItems;
    }

    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        pstm.executeUpdate();

    }

    @Override
    public void saveItem(String code, String description, BigDecimal unitPrice,int qtyOnHand) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, code);
        pstm.setString(2, description);
        pstm.setBigDecimal(3, unitPrice);
        pstm.setInt(4, qtyOnHand);
        pstm.executeUpdate();
    }

    @Override
    public void updateItem(String code, String description, BigDecimal unitPrice,int qtyOnHand) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, description);
        pstm.setBigDecimal(2, unitPrice);
        pstm.setInt(3, qtyOnHand);
        pstm.setString(4, code);
        pstm.executeUpdate();
    }

    @Override
    public boolean existsItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();
    }

    @Override
    public String itemCode() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        if (rst.next()){
            return rst.getString(1);
        }

        return null;

    }



    @Override
    public ItemDTO findItemData(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, code);
        ResultSet rst = pstm.executeQuery();
        //rst.next();
        //return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

        if (rst.next()){
            return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        }

        return null;

    }

    @Override
    public ItemDTO searchItems(String newItemCode) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, newItemCode + "");
        ResultSet rst = pstm.executeQuery();

        //rst.next();
        //ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

        if (rst.next()){
            return new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        }else{
            throw new SQLException("No Item found with item code: " + newItemCode);
        }

    }

    @Override
    public boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand, Connection connection) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, description);
        pstm.setBigDecimal(2, unitPrice);
        pstm.setInt(3, qtyOnHand);
        pstm.setString(4, code);
        return pstm.executeUpdate() > 0;
    }



}