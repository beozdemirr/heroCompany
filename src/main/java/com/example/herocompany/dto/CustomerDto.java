package com.example.herocompany.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    private Long mailId;
}

