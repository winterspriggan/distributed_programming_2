package insurance_system_customer_service.dto;

import lombok.Data;

@Data
public class ContractDTO {

    public ContractDTO(String id, String customer_id, String product_id, int premium) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.premium = premium;
    }

    public String id;
    public String customer_id;
    public String product_id;
    public int premium;

}
