package com.example.herocompany.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Detail cant be blank")
    @Length(message = "Product name must contain max  50 character.", max = 50)
    private String productName;

    @NotBlank(message = "Detail cant be blank")
    @Length(message = "Product detail must contain max  500 character.", max = 500)
    private String detail;

    @Range(message = "price can be between 5 and 9999", min = 5, max = 9999)
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
    @JoinTable(name = "attribute_products",
            joinColumns = {@JoinColumn(name = "attribute_id")},
            inverseJoinColumns = {@JoinColumn (name = "product_id")})
    private List<Attribute> attributes ;

}
