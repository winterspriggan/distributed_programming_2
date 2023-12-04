package insurance_system_employee_service.jpa.claim;

import insurance_system_employee_service.vo.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClaimRepository extends JpaRepository<ClaimEntity , String> {
    @Query("SELECT c FROM ClaimEntity c WHERE c.investigator = :investigator")
    List<ClaimEntity> getClaimByEmployeeId(@Param("investigator") String investigator);

    @Query("SELECT c FROM ClaimEntity c WHERE c.status = :status")
    List<ClaimEntity> getClaimsByStatus(@Param("status") Status status);

    @Query("SELECT c FROM ClaimEntity c WHERE c.id = :id")
    ClaimEntity getClaimsById(@Param("id") String id);
}
