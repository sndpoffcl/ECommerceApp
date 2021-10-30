package com.uprad.EcommerceApp.service;

import com.uprad.EcommerceApp.entity.Customer;
import com.uprad.EcommerceApp.entity.Order;
import com.uprad.EcommerceApp.exception.CustomerNotFoundException;
import com.uprad.EcommerceApp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer getCustomerDetails(int id) throws CustomerNotFoundException {
        Customer customer = customerRepo.findById(id);
        if(customer == null){
            throw new CustomerNotFoundException("Customer details not found for id : " + id);
        }else{
            return customer;
        }
    }

    @Override
    public Customer acceptCustomerDetails(Customer customer) {
        Customer savedCustomer = customerRepo.save(customer);
        return savedCustomer;
    }

    @Override
    public Customer deleteCustomerDetails(Customer customer) throws CustomerNotFoundException {
        Customer savedCustomer = getCustomerDetails(customer.getId());
        if(savedCustomer != null) {
            customerRepo.delete(customer);
            return customer;
        }
        return null;
    }

    @Override
    public Customer updateCustomerDetails(Customer customer) {
        return acceptCustomerDetails(customer);
    }

    @Override
    public List<Order> getOrders(Customer customer) throws CustomerNotFoundException {
        Customer savedCustomer = getCustomerDetails(customer.getId());
        return savedCustomer.getOrders();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.getAllCustomer();
    }
}
