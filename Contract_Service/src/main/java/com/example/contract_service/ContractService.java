package com.example.contract_service;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    List<Contract> getAllContracts();

    Contract addContract(ContractDTO contractDTO);

    void deleteContract(String id);

    public Contract getContractById(String id);
    Contract updatePremium(ContractDTO contractDTO);


}
