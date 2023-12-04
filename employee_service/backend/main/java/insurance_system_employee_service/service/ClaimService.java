package insurance_system_employee_service.service;

import insurance_system_employee_service.jpa.claim.ClaimEntity;
import insurance_system_employee_service.jpa.claim.ClaimRepository;
import insurance_system_employee_service.service.vo.ClaimVO;
import insurance_system_employee_service.service.vo.EmployeeVO;
import insurance_system_employee_service.service.vo.Status;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimService {
    private final ClaimRepository claimRepository;
    private final KieContainer kieContainer;

    public List<ClaimVO> getManagingClaims(EmployeeVO vo) {
        List<ClaimVO> claimVOS = new ArrayList<>();
        List<ClaimEntity> claimEntities = claimRepository.getClaimByEmployeeId(vo.getId());;
        for(ClaimEntity claim : claimEntities) {
            if(claim.getStatus().equals(Status.REPORTING) || claim.getStatus().equals(Status.REVIEWING))
            claimVOS.add(entityToVO(claim));
        }
        return claimVOS;
    }

    public boolean submitReport(ClaimVO claimVO) {
        ClaimEntity claimEntity = claimRepository.getClaimsById(claimVO.getId());
        ClaimVO claim = entityToVO(claimEntity);
        claim.setCompensation(claimVO.getCompensation());
        excuteRules(claim);
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

    public void excuteRules(ClaimVO vo) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(vo);
        kieSession.fireAllRules();
        kieSession.dispose();
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
