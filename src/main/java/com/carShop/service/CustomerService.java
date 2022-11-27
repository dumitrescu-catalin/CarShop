package com.carShop.service;

import com.carShop.model.Customer;
import com.carShop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //GET
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    public Optional<Customer> getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.getCustomerByName(name);
    }

    public List<Customer> getCustomerByEmailAddress(String emailAddress) {
        return customerRepository.getCustomerByEmailAddress(emailAddress);
    }

    public List<Customer> getCustomerByAddressAndPhoneNumber(String address, int phoneNumber) {
        return customerRepository.getCustomerByAddressAndPhoneNumber(address, phoneNumber);
    }

    //POST

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //PUT
    public Customer editCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //DELETE

    public void deleteCustomerById(int id){
        customerRepository.deleteById(id);
    }


}
