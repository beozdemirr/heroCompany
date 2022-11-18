package com.example.herocompany.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String mail;

    @OneToOne(mappedBy = "mail")
    private Customer customer;

}
