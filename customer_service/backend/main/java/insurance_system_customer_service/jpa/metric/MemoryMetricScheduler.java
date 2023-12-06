package insurance_system_customer_service.jpa.metric;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Component
public class MemoryMetricScheduler {

    private final MemoryMetricRepository memoryMetricRepository;

    @Autowired
    public MemoryMetricScheduler(MemoryMetricRepository memoryMetricRepository) {
        this.memoryMetricRepository = memoryMetricRepository;
    }

    @Scheduled(fixedRate = 30000)
    public void saveMemoryMetrics() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String actuatorEndpointUrl = "http://localhost:40021/actuator/metrics/jvm.memory.used";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(actuatorEndpointUrl, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String responseBody = responseEntity.getBody();
            JsonNode jsonNode = new ObjectMapper().readTree(responseBody);
            Double usedMemory = jsonNode.get("measurements").get(0).get("value").asDouble();
            MemoryMetric memoryMetric = new MemoryMetric();
            memoryMetric.setUsedMemory(usedMemory);
            memoryMetric.setTimestamp(new Date());
            memoryMetric.setId(UUID.randomUUID().toString());
            memoryMetricRepository.save(memoryMetric);
        }
    }
}
