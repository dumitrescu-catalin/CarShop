package com.carShop.model;
import lombok.Data;
import jakarta.persistence.*;
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
