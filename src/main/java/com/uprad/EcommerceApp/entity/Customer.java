package com.uprad.EcommerceApp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private String address;

    private List<Order> orders;
}
