package com.example.model;

import lombok.Data;

@Data
public class User {
    private int ID;
    private String name;
    private Address address;
}
