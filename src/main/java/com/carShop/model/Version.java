package com.carShop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "versions")
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "version_name")
    private String name;
    @Column(name = "version_description")
    private String description;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private List<Car> Cars;




}
