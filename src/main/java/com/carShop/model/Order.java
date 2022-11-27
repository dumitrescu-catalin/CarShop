package com.carShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "orders")
public class Order {

    LocalDate date;
    @ManyToMany
    @JoinTable(
            name = "CARS_ORDERS",
            joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CARS_ID", referencedColumnName = "ID")
    )
    List<Car> cars;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_name")
    private String name;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
