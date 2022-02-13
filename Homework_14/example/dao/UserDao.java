package com.example.dao;

import com.example.model.Address;
import com.example.model.User;

public interface UserDao {
    User getUserByName(String name);
    User getUserByID(int id);
    Address getAddressByID(int id);
}
