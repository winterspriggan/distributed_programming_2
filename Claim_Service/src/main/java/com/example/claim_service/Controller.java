package com.example.claim_service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ClaimService claimService;

    @GetMapping("/claims")
    public List<Claim> getAllClaimss() {
        return claimService.getAllClaimss();
    }

    @PostMapping("/claim")
    public boolean addClaim(@RequestBody ClaimDTO claimDTO) {
        return claimService.addClaim(claimDTO);
    }

    @GetMapping("/claim/contract_id/{contract_id}")
    public List<Claim> getClaimsByContractId(@PathVariable String contract_id) {
        return claimService.getClaimsByContractId(contract_id);
    }
//
//    @GetMapping("/claim/id/{id}")
//    public Claim getClaimById(@PathVariable String id) {
//        return claimService.getClaimById(id);
//    }
//
    @PutMapping("/uClaim")
    public boolean updateClaim(@RequestBody ReportDTO reportDTO) {
        return claimService.updateClaim(reportDTO);
    }
//
    @DeleteMapping("/claim/{id}")
    public boolean deleteClaimByID(@PathVariable String id) {
        return claimService.deleteClaimByID(id);
    }
}

