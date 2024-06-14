package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {

        public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

        public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

        public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

        public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

        public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

        public String getCurrentId() throws SQLException, ClassNotFoundException;

        public CustomerDTO getCustomerName(String newValue) throws SQLException, ClassNotFoundException;

        public ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException;

}
