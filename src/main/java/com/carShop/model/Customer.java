package com.carShop.model;


import lombok.Data;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private int phoneNumber;


    @OneToMany
    List<Order> orders;



}
