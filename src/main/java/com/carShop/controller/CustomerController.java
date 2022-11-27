package com.carShop.controller;


import com.carShop.exception.ResourceNotFoundException;
import com.carShop.model.Customer;
import com.carShop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")       //localhost:8080/api/customers
public class CustomerController {

    private final CustomerService customerService;


    //GET
    @GetMapping("/allCustomers")            //localhost:8080/api/customers/allCustomers
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        if (customerList.size() == 0) {
            throw new ResourceNotFoundException("There are no customers in database!");
        }
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/customerById/{id}")        //localhost:8080/api/customers/customerById
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer customer = customerService.getCustomerById(id).orElseThrow(() -> new ResourceNotFoundException("Customer with id: " + id + " not found in DB!"));
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customersByName/{name}")        //localhost:8080/api/customers/customersByName
    public ResponseEntity<List<Customer>> getCustomersByName(@PathVariable String name) {
        List<Customer> customerList = customerService.getCustomersByName(name);
        if (customerList.size() == 0) {
            throw new ResourceNotFoundException("Customers with name" + name + " not found!");
        }
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/customersByEmail")        //localhost:8080/api/customers/customersByEmail
    public ResponseEntity<List<Customer>> getCustomerByEmailAddress(@RequestParam(value = "email") String emailAddress) {
        List<Customer> customerList = customerService.getCustomerByEmailAddress(emailAddress);
        if (customerList.size() == 0) {
            throw new ResourceNotFoundException("Customers with email_Address" + emailAddress + " not found!");
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/customersByAddressAndPhoneNumber/{address}/{phoneNumber}")        //localhost:8080/api/customers/customersByAddressAndPhoneNumber
    public ResponseEntity<List<Customer>> getCustomerByAddressAndPhoneNumber(@PathVariable String address, @PathVariable int phoneNumber) {
        List<Customer> customerList = customerService.getCustomerByAddressAndPhoneNumber(address, phoneNumber);
        if (customerList.size() == 0) {
            throw new ResourceNotFoundException("Customers with address and Phone_Number: " + address + ", " + phoneNumber + " not found in DB!");
        }
        return ResponseEntity.ok(customerList);
    }

    //POST
    @PostMapping("/addNewCustomer")     //localhost:8080/api/customers/addNewCustomer
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    //PUT
    @PutMapping("/updateCustomer")    //localhost:8080/api/customers/updateCustomer
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.editCustomer(customer);
        return ResponseEntity.ok(customer1);
    }

    //DELETE
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id ){
        customerService.getCustomerById(id).orElseThrow(()-> new ResourceNotFoundException("Customer with id: " + id + " not found in DB!"));
        customerService.deleteCustomerById(id);

        return new ResponseEntity<>("Customer with id: " + id + "deleted successfully", HttpStatus.OK);
    }



}
