package com.carShop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "versions")
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "version_name")
    private String name;
    @Column(name = "version_description")
    private String description;


    @OneToMany(mappedBy = "version")
    List<Car> cars;



}
