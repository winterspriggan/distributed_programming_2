package com.example.contract_service;

import java.util.List;

public interface ContractService {

    List<Contract> getAllContracts();

    Contract addContract(ContractDTO contractDTO);


}
