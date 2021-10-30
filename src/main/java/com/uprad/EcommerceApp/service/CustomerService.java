package com.uprad.EcommerceApp.service;

import com.uprad.EcommerceApp.entity.Customer;
import com.uprad.EcommerceApp.entity.Order;

import java.util.List;

public interface CustomerService {
    public Customer getCustomerDetails(int id);
    public Customer acceptCustomerDetails(Customer customer);
    public Customer deleteCustomerDetails(Customer customer);
    public Customer updateCustomerDetails(Customer customer);
    public List<Order> getOrders(Customer customer);
    public List<Customer> getAllCustomer();
}
