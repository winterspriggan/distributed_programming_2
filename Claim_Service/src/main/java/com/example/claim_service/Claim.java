package com.example.claim_service;

import lombok.Getter;

@Getter
public class Claim {

        public Claim(ClaimDTO claimDTO) {
                this.id = claimDTO.getId();
                this.compensation = claimDTO.getCompensation();
                this.contract_id = claimDTO.getContract_id();
                this.date = claimDTO.getDate();
                this.description = claimDTO.getDescription();
                this.report = claimDTO.getReport();
                this.status = claimDTO.getStatus();
                this.investigator = claimDTO.getInvestigator();
        }
        public enum Status {
                REPORTING, REVIEWING, ACCEPTED, REJECTED, PAID
        }

        private String id;
        private int compensation;
        private String contract_id;
        private String date;
        private String description;
        private String report;
        private Status status;
        private String investigator;
}


