package com.example.contract_service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract")
public class Contract {
    @Id
//    @GeneratedValue
    @Column(name = "id" , nullable = false)
    private String id;
    @Column(name = "customer_id", nullable = false)
    private String customer_id;
    @Column(name = "product_id", nullable = false)
    private String product_id;
    @Column(name = "premium", nullable = false)
    private int premium;

    public Contract(ContractDTO contractDTO) {
        this.id = contractDTO.getId();
        this.customer_id = contractDTO.getCustomer_id();
        this.product_id = contractDTO.getProduct_id();
        this.premium = contractDTO.getPremium();
    }
}
