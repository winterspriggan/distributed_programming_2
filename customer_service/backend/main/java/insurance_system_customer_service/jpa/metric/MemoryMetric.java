package insurance_system_customer_service.jpa.metric;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class MemoryMetric {
    @Id
    private String id;
    private Double usedMemory;
    private Date timestamp;

    public void setUsedMemory(Double usedMemory) {
        this.usedMemory = usedMemory;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }
}
