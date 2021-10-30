package com.uprad.EcommerceApp.entity;

import lombok.Data;

@Data
public class Order {
    private int id;
    private int quantity;
    private int amount;
    private Product product;
}
