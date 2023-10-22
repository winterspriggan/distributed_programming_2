package com.example.contract_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{
    private final ContractRepository contractRepository;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract addContract(ContractDTO contractDTO) {
        Contract contract = new Contract(contractDTO);
        return contractRepository.save(contract);
    }
}
