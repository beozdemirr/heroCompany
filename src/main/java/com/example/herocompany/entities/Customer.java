package com.example.herocompany.entities;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "Firstname can't be blank")
    @Length(message = "Firstname must be between 3 and 50 characters", min = 3, max = 50)
   private String customerFirstName;


    @NotBlank(message = "Lastname can't be blank")
    @Length(message = "Lastname must be between 3 and 50 characters", min = 3, max = 50)
    private String customerLastName;


    @NotBlank(message = "Phone can't be blank")
    private String customerPhone;


}
