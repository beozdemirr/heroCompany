package com.example.herocompany.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Detail cant be blank")
    @Length(message = "Product name must contain max  50 character.",max=50)
    private String productName;

    @NotBlank(message = "Detail cant be blank")
    @Length(message = "Product detail must contain max  500 character.",max=500)
    private String detail;

    @Range(message = "price can be between 5 and 9999",min = 5,max = 9999)
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY,
    mappedBy = "products")
    private Set<Attribute> attributes = new HashSet<Attribute>();

}
