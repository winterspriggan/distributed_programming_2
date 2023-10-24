package com.example.contract_service.DAO;


import com.example.contract_service.Contract;
import com.example.contract_service.ContractDTO;

import java.util.ArrayList;
import java.util.List;

public class ContractDAO extends DAO {

    public ContractDAO() {
        super();
        databaseName = "insurance_system";
        tableName = "contract";
    }

    public boolean addContract(Contract contract) {
        String sql = "insert into " + tableName + " values(\'"+ contract.getId()+ "\',\'" + contract.getCustomer_id() + "\',\'" + contract.getProduct_id() + "\'," + contract.getPremium() + ");";
        return executeUpdate(sql);
    }
    public boolean deleteContract(String id) {
        String sql = "delete from " + tableName +" where id = \'"+id+"\';";
        return executeUpdate(sql);
    }

    public boolean updatePremium(Contract contract) {
        String sql = "update "+tableName+" set premium = "+contract.getPremium()+" where id = \'"+ contract.getId()+"\';";
        return executeUpdate(sql);

    }

    public List<Contract> findAllContracts() {
        String sql = "select * from " + tableName + ";";
        if (!executeQuery(sql)) return null;
        if(!next()) return null;
        List<Contract> contracts = new ArrayList<>();
        do {
            ContractDTO contractDTO = new ContractDTO();
            contractDTO.setId(getString("id"));
            contractDTO.setCustomer_id(getString("customer_id")) ;
            contractDTO.setProduct_id(getString("product_id"));
            contractDTO.setPremium( getInt("premium"));
            Contract contract = new Contract(contractDTO);
            contracts.add(contract);
        } while (next());
        return contracts;
    }
    public List<Contract> getContractsByCustomerId(String customerId) {
        String sql = "select * from " + tableName + " where customer_id=\'" + customerId + "\';";
        if (!executeQuery(sql)) return null;
        if(!next()) return null;
        List<Contract> contracts = new ArrayList<>();
        do {
//            Contract contract = new Contract();
            ContractDTO contractDTO = new ContractDTO();
            contractDTO.setId(getString("id"));
            contractDTO.setCustomer_id(getString("customer_id")) ;
            contractDTO.setProduct_id(getString("product_id"));
            contractDTO.setPremium( getInt("premium"));
            Contract contract = new Contract(contractDTO);
            contracts.add(contract);
        } while (next());
        return contracts;
    }

    public List<Contract> getContractsByProductId(String productId) {
        String sql = "select * from " + tableName + " where product_id=\'" + productId + "\';";
        if (!executeQuery(sql)) return null;
        if(!next()) return null;
        List<Contract> contracts = new ArrayList<>();
        do {
//            Contract contract = new Contract();
            ContractDTO contractDTO = new ContractDTO();
            contractDTO.setId(getString("id"));
            contractDTO.setCustomer_id(getString("customer_id")) ;
            contractDTO.setProduct_id(getString("product_id"));
            contractDTO.setPremium( getInt("premium"));
            Contract contract = new Contract(contractDTO);
            contracts.add(contract);
        } while (next());
        return contracts;
    }

}
