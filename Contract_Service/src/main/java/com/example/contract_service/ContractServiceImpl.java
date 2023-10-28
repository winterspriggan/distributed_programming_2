package com.example.contract_service;

import com.example.contract_service.DAO.ContractDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{
    private final ContractDAO contractDAO = new ContractDAO();
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

    @Override
    public void deleteContract(String id) {
        Contract contract = contractRepository.getContractByID(id);
        contractRepository.delete(contract);
    }

    @Override
    public Contract getContractById(String id) {
        return contractRepository.getContractByID(id);
    }


    @Override
    public Contract updatePremium(ContractDTO contractDTO) {
        Contract contract = new Contract(contractDTO);
        return contractRepository.save(contract);
    }


}
