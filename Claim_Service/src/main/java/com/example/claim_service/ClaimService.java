package com.example.claim_service;

import java.util.List;

public interface ClaimService {
    public List<Claim> getAllClaimss();

    public boolean addClaim(ClaimDTO claimDTO);

    List<Claim> getClaimsByContractId(String contractId);

    boolean deleteClaimByID(String id);

    boolean updateClaim(ReportDTO reportDTO);
}
