package com.example.claim_service;

import lombok.Data;

@Data
public class ReportDTO {
    private String id;
    private String report;
    private Claim.Status status;
    private String investigator;
}
