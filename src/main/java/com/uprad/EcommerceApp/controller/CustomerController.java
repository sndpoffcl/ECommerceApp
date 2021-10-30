package com.uprad.EcommerceApp.controller;

import com.uprad.EcommerceApp.entity.Customer;
import com.uprad.EcommerceApp.entity.Order;
import com.uprad.EcommerceApp.exception.CustomerNotFoundException;
import com.uprad.EcommerceApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}") // GET https://localhost:8080/customer/1
    public ResponseEntity getCustomerDetails(@PathVariable("id") int id){
        try{
            Customer savedCustomer = customerService.getCustomerDetails(id);
            return ResponseEntity.ok(savedCustomer);
        }catch (CustomerNotFoundException cex){
           return ResponseEntity.ok("Customer Details not found");
        }
    }


    @GetMapping("/customer-order/{id}")
    public ResponseEntity getCustomerOrderList(@PathVariable("id") int id){
        Customer savedCustomer = customerService.getCustomerDetails(id);
        List<Order> orders = customerService.getOrders(savedCustomer);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/customer")
    public ResponseEntity acceptCustomerDetails(@RequestBody Customer customer){
        Customer newCustomer = customerService.acceptCustomerDetails(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity deleteCustomerDetails(@PathVariable("id") int id){
        Customer savedCustomer = customerService.getCustomerDetails(id);
        customerService.deleteCustomerDetails(savedCustomer);
        return ResponseEntity.ok("Customer Deleted");
    }

    @GetMapping("/customer")
    public ResponseEntity getAllCustomerDetails(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

}
