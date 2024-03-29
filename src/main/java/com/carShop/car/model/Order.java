package com.carShop.car.model;

import com.carShop.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_name")
    private String name;
    LocalDate date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "CARS_ORDERS",
            joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CARS_ID", referencedColumnName = "ID")
    )
    List<Car> cars;

}
