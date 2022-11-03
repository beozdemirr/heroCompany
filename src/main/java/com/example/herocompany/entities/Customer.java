package com.example.herocompany.entities;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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


    @NotNull(message = "Email not null")
    @Email(message = "Email should be valid")
    private String customerEmail;


    @NotBlank(message = "password can not be blank")
    @Pattern(message = "Password must contain min one upper,lower letter and 0-9 digit number ",
            regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{6,}")
    private String customerPassword;

}
