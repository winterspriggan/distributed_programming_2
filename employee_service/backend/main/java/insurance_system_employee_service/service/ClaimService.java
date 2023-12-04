package insurance_system_employee_service.service;

import insurance_system_employee_service.jpa.claim.ClaimEntity;
import insurance_system_employee_service.jpa.claim.ClaimRepository;
import insurance_system_employee_service.jpa.employee.EmployeeEntity;
import insurance_system_employee_service.jpa.employee.EmployeeRepository;
import insurance_system_employee_service.vo.ClaimVO;
import insurance_system_employee_service.vo.Department;
import insurance_system_employee_service.vo.EmployeeVO;
import insurance_system_employee_service.vo.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClaimService {
    private final ClaimRepository claimRepository;

    public List<ClaimVO> getManagingClaims(EmployeeVO vo) {
        List<ClaimVO> claimVOS = new ArrayList<>();
        List<ClaimEntity> claimEntities = claimRepository.getClaimByEmployeeId(vo.getId());;
        for(ClaimEntity claim : claimEntities) {
            claimVOS.add(entityToVO(claim));
        }
        return claimVOS;
    }

    public boolean submitReport(ClaimVO claimVO) {
        ClaimEntity claimEntity = claimRepository.getClaimsById(claimVO.getId());
        ClaimVO claim = entityToVO(claimEntity);
        if(claimVO.getCompensation() != 0) claim.setStatus(Status.ACCEPTED.toString());
        else claim.setStatus(Status.REJECTED.toString());
        claim.setCompensation(claimVO.getCompensation());
        claim.setReport(claimVO.getReport());
        claimRepository.save(vOToEntity(claim));
        return true;
    }

    public List<ClaimVO> getClaimsByStatus(Status status) {
        List<ClaimVO> claimVOS = new ArrayList<>();
        List<ClaimEntity> claimEntities = claimRepository.getClaimsByStatus(status);;
        for(ClaimEntity claim : claimEntities) {
            claimVOS.add(entityToVO(claim));
        }
        return claimVOS;
    }

    public boolean payCompensation(ClaimVO claimVO) {
        if(!claimVO.getStatus().toString().equals( Status.ACCEPTED.toString())) return false;
        ClaimEntity claimEntity = claimRepository.getClaimsById(claimVO.getId());
        ClaimVO claim = entityToVO(claimEntity);
        claim.setStatus("PAID");
        claimRepository.save(vOToEntity(claim));
        return true;
    }

    public Float getClaimStatistics() {
        List<ClaimEntity> clalims = claimRepository.getClaimsByStatus(Status.ACCEPTED);
        int sumCompensation = 0;
        for(ClaimEntity claim : clalims) {
            sumCompensation += claim.getCompensation();
        }
        return (float) sumCompensation/clalims.size();
    }


    public ClaimVO entityToVO(ClaimEntity claim) {
        ClaimVO claimVO = new ClaimVO(claim.getId()
                , claim.getCompensation()
                , claim.getContract_id()
                , claim.getDate()
                , claim.getDescription()
                , claim.getInvestigator()
                , claim.getReviewer()
                , claim.getReport()
                , claim.getStatus().toString()
        );
        return claimVO;
    }

    public ClaimEntity vOToEntity(ClaimVO claim) {
        ClaimEntity claimEntity = new ClaimEntity(claim.getId()
                , claim.getCompensation()
                , claim.getContract_id()
                , claim.getDate()
                , claim.getDescription()
                , claim.getInvestigator()
                , claim.getReviewer()
                , claim.getReport()
                , claim.getStatus()
        );
        return claimEntity;
    }
}
