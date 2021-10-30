package com.uprad.EcommerceApp.repository;

import com.uprad.EcommerceApp.entity.Customer;
import com.uprad.EcommerceApp.entity.Order;

import java.util.HashMap;

public class OrderRepo {

    private static HashMap<Integer, Order> orderMap = new HashMap<>();

    public Order findById(int id){
        return orderMap.get(id);
    }

    public Order save(Order order){
        orderMap.put(order.getId(), order);
        return order;
    }

    public void delete(Order order){
        orderMap.remove(order.getId());
    }
}
