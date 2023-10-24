package com.example.contract_service;

import java.util.List;

public interface ContractService {

    List<Contract> getAllContracts();

    Contract addContract(ContractDTO contractDTO);

    boolean deleteContract(String id);

    List<Contract> getContractByCustomerId(String id);
    List<Contract> getContractByProductId(String id);

    boolean updatePremium(ContractDTO contractDTO);


}
