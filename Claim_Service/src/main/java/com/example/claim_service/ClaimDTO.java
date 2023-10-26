package com.example.claim_service;

import lombok.Data;

@Data
public class ClaimDTO {


    private String id;
    private int compensation;
    private String contract_id;
    private String date;
    private String description;
    private String report;
    private Claim.Status status;
    private String investigator;
}
