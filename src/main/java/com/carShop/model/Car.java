package com.carShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand_name")
    private String brand;
    @Column(name = "model_name")
    private String model;
    @Column(name = "car_color")
    private String color;
    @Column(name = "engine_model")
    private String engineModel;
    @Column(name = "power_hp")
    private int powerHp;
    @Column(name = "price")
    private double price;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "cars")
    List<Order> orders;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CAR_VERSION",
            joinColumns = @JoinColumn(name = "CAR_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "VERSION_ID", referencedColumnName = "ID")
    )
    Version version;




}
