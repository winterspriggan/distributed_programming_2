package insurance_system_employee_service.service;


import insurance_system_employee_service.jpa.product.ProductEntity;
import insurance_system_employee_service.jpa.product.ProductRepository;
import insurance_system_employee_service.service.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;



    public List<ProductVO> getAllProduct() {
        List<ProductVO> products = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        for(ProductEntity product : productEntities) {
            products.add(new ProductVO(
                      product.getId()
                    , product.getName()
                    , product.getPremium()
                    , product.getSeniorRate()
                    , product.getMaleRate()
                    , product.getFemaleRate()
                    , product.getOccupationHazardRate()
                    , product.getSmokingRate()
                    , product.getReleased()
            ));
        }
        return products;
    }

    public void underwrite(ProductVO vo) {
        ProductEntity temp = productRepository.getProductByName(vo.getName());
         ProductEntity product = ProductEntity.builder()
                 .id(temp.getId())
                .occupationHazardRate(temp.getOccupationHazardRate())
                .seniorRate(temp.getSeniorRate())
                .femaleRate(temp.getFemaleRate())
                .maleRate(temp.getMaleRate())
                .released(1)
                .build();
        productRepository.save(product);
    }

    public ProductVO developProduct(ProductVO vo) {
        List<ProductVO> temp =getAllProduct();
        for(ProductVO product : temp)  if(vo.getName().equals(product.getName())) return null;
        String pID = temp.get(temp.size()-1).getId();
        pID = pID.substring(1).trim();
        ProductEntity product = ProductEntity.builder()
                .id("P"+(Integer.parseInt(pID)+1))
                .name(vo.getName())
                .premium(vo.getPremium())
                .occupationHazardRate(-1)
                .seniorRate(-1)
                .femaleRate(-1)
                .maleRate(-1)
                .released(0)
                .build();
        vo.setId(product.getId());
        productRepository.save(product);
        return vo;
    }
}
