package com.uprad.EcommerceApp.repository;

import com.uprad.EcommerceApp.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepo {

    private static HashMap<Integer, Customer> customerMap = new HashMap<>();

    public Customer findById(int id){
        return customerMap.get(id);
    }

    public Customer save(Customer customer){
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public void delete(Customer customer){
        customerMap.remove(customer.getId());
    }

    public List<Customer>  getAllCustomer(){
        List<Customer> customers = new ArrayList<>();
        for(Map.Entry<Integer,Customer> e : customerMap.entrySet() ){
            customers.add(e.getValue());
        }
        return customers;
    }

}
