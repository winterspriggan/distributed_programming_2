package insurance_system_customer_service.jpa.metric;

import insurance_system_customer_service.jpa.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryMetricRepository extends JpaRepository<MemoryMetric, Long> {

}
