package com.carShop.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer register(CustomerRegister customer) {
        var newCustomer = Customer.builder().firstname(customer.getFirstname())
                .lastname(customer.getLastname()).email(customer.getEmail())
                .password(customer.getPassword()).phoneNumber(customer.getPhoneNumber())
                .role(Role.USER).build();
        return customerRepository.save(newCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return customerRepository.findByEmail(email);
    }
}
