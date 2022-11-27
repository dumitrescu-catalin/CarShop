package com.carShop.repository;

import com.carShop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> getCustomerByName(String name);

    List<Customer> getCustomerByEmailAddress(String emailAddress);

    List<Customer> getCustomerByAddressAndPhoneNumber(String address, int phoneNumber);


}
