package com.example.herocompany.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String mail;

    @JsonIgnore
    @OneToOne(mappedBy = "mail")
    private Customer customer;

}
