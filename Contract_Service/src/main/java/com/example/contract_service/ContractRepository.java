package com.example.contract_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractRepository extends JpaRepository<Contract , String> {
    @Query("select c from Contract c where c.id = :contract_id")
    Contract getContractByID(@Param("contract_id") String id);

}
