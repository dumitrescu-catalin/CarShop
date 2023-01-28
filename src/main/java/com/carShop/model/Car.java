package com.carShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
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

    @ManyToOne
    @JoinColumn(name = "version_id")
    private Version version;

}
