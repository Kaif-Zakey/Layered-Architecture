package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {

    public ArrayList<ItemDTO>  getAllItem() throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    public boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException;
    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    public String getCurrentId() throws SQLException, ClassNotFoundException;
    public ItemDTO getItemByCode(String code) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllItemCodes() throws SQLException, ClassNotFoundException;
    public boolean updateQty(ItemDTO item) throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;

}
