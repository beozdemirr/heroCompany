package com.example.herocompany.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ProductDto {
    private String productName;
    private String detail;
    private int price;
    private Long categoryId;
    private List<Long> attributesIdList;
}
