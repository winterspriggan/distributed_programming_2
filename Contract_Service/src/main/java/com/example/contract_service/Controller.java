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

    @GetMapping("/contract/customer_id/{customer_id}")
    public List<Contract> getContractByCustomerId(@PathVariable String customer_id) {
        return contractService.getContractByCustomerId(customer_id);
    }

    @GetMapping("/contract/product_id/{product_id}")
    public List<Contract> getContractByProductId(@PathVariable String product_id) {
        return contractService.getContractByProductId(product_id);
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
