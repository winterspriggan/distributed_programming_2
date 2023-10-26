package com.example.claim_service;


import com.example.claim_service.DAO.ClaimDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService{
    ClaimDAO claimDAO = new ClaimDAO();

    @Override
    public List<Claim> getAllClaimss() {
        return claimDAO.getAllClaims();
    }

    @Override
    public boolean addClaim(ClaimDTO claimDTO) {
        return claimDAO.addClaim(new Claim(claimDTO));
    }

    @Override
    public List<Claim> getClaimsByContractId(String contractId) {
        return claimDAO.getClaimsByColumn("id", contractId);
    }

    @Override
    public boolean deleteClaimByID(String id) {
        return claimDAO.deleteClaim(id);
    }

    @Override
    public boolean updateClaim(ReportDTO reportDTO) {
        return claimDAO.updateReport(reportDTO);
    }
}
