package com.example.contract_service;

import com.example.contract_service.DAO.ContractDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{
    private final ContractDAO contractDAO = new ContractDAO();

    @Override
    public List<Contract> getAllContracts() {
//        List<Contract> contracts = new ArrayList<>();
        return contractDAO.findAllContracts();
    }

    @Override
    public Contract addContract(ContractDTO contractDTO) {
        Contract contract = new Contract(contractDTO);
        if(contractDAO.addContract(contract)) return contract;
        return null;
    }

    @Override
    public boolean deleteContract(String id) {
        return contractDAO.deleteContract(id);
    }

    @Override
    public List<Contract> getContractByCustomerId(String id) {
        return contractDAO.getContractsByCustomerId(id);
    }

    @Override
    public List<Contract> getContractByProductId(String id) {
        return contractDAO.getContractsByProductId(id);
    }

    @Override
    public boolean updatePremium(ContractDTO contractDTO) {
        Contract contract = new Contract(contractDTO);
        return contractDAO.updatePremium(contract);
    }


}
