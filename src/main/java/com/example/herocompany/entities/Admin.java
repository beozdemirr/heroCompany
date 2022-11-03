package com.example.herocompany.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Admin name can not be blank")
    @Length(message = "Admin name must contain min 2 max  5O character.", min = 2, max = 50)
    private String adminName;

    @NotBlank(message = "admin surname can not be blank")
    @Length(message = "Admin surname must contain min 2 max  5O character.", min = 2, max = 50)
    private String adminSurname;

    @NotBlank(message = "Company name can not be blank")
    @Length(message = "Company name must contain min 2 max  50 character.", min = 2, max = 50)
    private String companyName;



    @Column(unique = true)
    @Length(message = "Maximum 60", max = 60)
    @NotBlank(message = "Email can not be blank")
    @Email(message = "Email Format Error")
    private String email;

    @NotBlank(message = "password can not be blank")
    @Pattern(message = "Password must contain min one upper,lower letter and 0-9 digit number ",
            regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{6,}")
    private String password;



}
