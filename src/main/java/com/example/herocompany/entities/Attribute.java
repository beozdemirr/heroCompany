package com.example.herocompany.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feature;

@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "attributes")
    private Set<Product> products = new HashSet<>();
}
