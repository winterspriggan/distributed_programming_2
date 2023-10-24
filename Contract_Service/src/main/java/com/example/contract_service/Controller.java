package com.example.contract_service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ContractService contractService;

    @GetMapping("/contracts")
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @PostMapping("/contract")
    public Contract addContract(@RequestBody ContractDTO contractDTO) {
        return contractService.addContract(contractDTO);
    }

    @GetMapping("/contract/{id}")
    public List<Contract> getContractByCustomerId(@PathVariable String id) {
        return contractService.getContractByCustomerId(id);
    }

    @DeleteMapping("/contract/{id}")
    public boolean deleteContract(@PathVariable String id) {
        return contractService.deleteContract(id);
    }

    @PostMapping("/uContract")
    public boolean updatePremium(@RequestBody ContractDTO contractDTO) {
        return contractService.updatePremium(contractDTO);
    }


}
