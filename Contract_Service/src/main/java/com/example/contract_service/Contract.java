package com.example.contract_service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
//@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    private String id;
    private String customer_id;
    private String product_id;
    private int premium;

    public Contract(ContractDTO contractDTO) {
        this.id = contractDTO.getId();
        this.customer_id = contractDTO.getCustomer_id();
        this.product_id = contractDTO.getProduct_id();
        this.premium = contractDTO.getPremium();
    }
}
