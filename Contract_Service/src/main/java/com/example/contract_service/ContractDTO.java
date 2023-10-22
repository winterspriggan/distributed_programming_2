package com.example.contract_service;

import lombok.Data;
@Data
public class ContractDTO {
    private String id;
    private String customer_id;
    private String product_id;
    private int premium;
}
