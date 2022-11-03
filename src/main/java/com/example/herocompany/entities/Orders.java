package com.example.herocompany.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Orders {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
/*

   @ManyToOne
   @JoinColumn(name = "customerId")
   private Customer customer;

*/




}
