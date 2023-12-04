package insurance_system_customer_service.service;

import insurance_system_customer_service.jpa.contract.ContractEntity;
import insurance_system_customer_service.jpa.contract.ContractRepository;
import insurance_system_customer_service.jpa.customer.CustomerEntity;
import insurance_system_customer_service.jpa.customer.CustomerRepository;
import insurance_system_customer_service.jpa.product.ProductEntity;
import insurance_system_customer_service.jpa.product.ProductRepository;
import insurance_system_customer_service.service.vo.ContractVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public boolean createContract(ContractVO vo) {
        ContractEntity contract = contractRepository.findByCustomerIdAndProductId(vo.getCustomer_id(), vo.getProduct_id());
        if(contract != null){
            return false;
        }

        CustomerEntity customer = customerRepository.findById(vo.getCustomer_id());
        ProductEntity product = productRepository.findById(vo.getProduct_id());
        int premium = product.getPremium();
        if (2023 - Integer.parseInt(customer.getBirth().split("-")[0]) > 60) premium *= product.getSenior_rate();
        if (customer.getGender() == 0) premium *= product.getMale_rate();
        if (customer.getGender() == 1) premium *= product.getFemale_rate();
        if (customer.getOccupationalHazard() == 1) premium *= product.getOccupational_hazard_rate();
        if (customer.getSmoking() == 1) premium *= product.getSmoking_rate();

        ContractEntity entity = ContractEntity.builder()
                .id(UUID.randomUUID().toString())
                .customer_id(vo.getCustomer_id())
                .product_id(vo.getProduct_id())
                .premium(premium)
                .build();
        ContractEntity saveEntity = contractRepository.save(entity);
        if (saveEntity != null) return true;
        return false;
    }

    public List<ContractVO> getContracts(String id) {
        List<ContractEntity> entityList = contractRepository.findAllById(id);
        if (entityList.isEmpty() || entityList == null) return null;
        List<ContractVO> contractVOList = new ArrayList<>();
        for (ContractEntity entity : entityList) {
            ContractVO vo = new ContractVO(entity.getId(), entity.getCustomer_id(), entity.getProduct_id(), entity.getPremium());
            contractVOList.add(vo);
        }
        return contractVOList;
    }
}
