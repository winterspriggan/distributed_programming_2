package com.example.contract_service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue
    private String id;
    @Column(name ="cusotmer_id", nullable = false)
    private String customer_id;
    @Column(name ="product_id", nullable = false)
    private String product_id;
    @Column(name ="premium", nullable = false)
    private int premium;

    public Contract(ContractDTO contractDTO) {
        this.id = contractDTO.getId();
        this.customer_id = contractDTO.getCustomer_id();
        this.product_id = contractDTO.getProduct_id();
        this.premium = contractDTO.getPremium();
    }
}
