package insurance_system_customer_service.service;

import insurance_system_customer_service.jpa.claim.ClaimEntity;
import insurance_system_customer_service.jpa.claim.ClaimRepository;
import insurance_system_customer_service.jpa.employee.EmployeeEntity;
import insurance_system_customer_service.jpa.employee.EmployeeRepository;
import insurance_system_customer_service.service.vo.ClaimVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final EmployeeRepository employeeRepository;
    private final ClaimRepository claimRepository;

    public boolean createClaim(ClaimVO vo) {
        List<EmployeeEntity> investigators = employeeRepository.getEmployeesByDepartment(EmployeeEntity.Department.INVESTIGATING);
        List<EmployeeEntity> reviewers = employeeRepository.getEmployeesByDepartment(EmployeeEntity.Department.SUPPORTING);
        Map<String, Integer> investigatingCount = new HashMap<>();
        Map<String, Integer> reviewingCount = new HashMap<>();
        for(EmployeeEntity investigator : investigators) investigatingCount.put(investigator.getId(), 0);
        for(EmployeeEntity reviewer : reviewers) reviewingCount.put(reviewer.getId(), 0);
        List<ClaimEntity> reportingClaims = claimRepository.getClaimsByStatus(ClaimEntity.Status.REPORTING);
        for(ClaimEntity reportingClaim : reportingClaims){
            investigatingCount.replace(reportingClaim.getInvestigator(), investigatingCount.get(reportingClaim.getInvestigator()) + 1);
            reviewingCount.replace(reportingClaim.getReviewer(), reviewingCount.get(reportingClaim.getReviewer()) + 1);
        }
        String investigator = assignEmployee(investigators, investigatingCount);
        String reviewer = assignEmployee(reviewers, reviewingCount);

        ClaimEntity claimEntity = ClaimEntity.builder()
                .id(UUID.randomUUID().toString())
                .compensation(vo.getCompensation())
                .contract_id(vo.getContract_id())
                .date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .description(vo.getDescription())
                .investigator(investigator)
                .reviewer(reviewer)
                .report(null)
                .status(ClaimEntity.Status.REPORTING)
                .build();
        ClaimEntity saveClaim = claimRepository.save(claimEntity);
        if(saveClaim != null) return true;
        return false;
    }

    private String assignEmployee(List<EmployeeEntity> departments, Map<String, Integer> departmentCounting) {
        String employee = departments.get(0).getId();
        int min = Integer.MAX_VALUE;
        for (String employeeId : departmentCounting.keySet()) {
            if (departmentCounting.get(employeeId) < min) {
                employee = employeeId;
                min = departmentCounting.get(employeeId);
            }
        }
        return employee;
    }
}
