package com.example.claim_service.DAO;

import com.example.claim_service.Claim;

public class Claim_ManageDAO extends DAO{
    public Claim_ManageDAO() {
        databaseName = "insurance_system";
        tableName = "claim_manage";
    }

    public boolean addClaim_Manage(Claim claim) {
        String sql = "insert into "+databaseName+" values(\'"+claim.getId()+"\' , \'"+claim.getInvestigator()+"\' , \'";
        return false;
    }
}
