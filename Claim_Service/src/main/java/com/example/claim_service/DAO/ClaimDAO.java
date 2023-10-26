package com.example.claim_service.DAO;

import com.example.claim_service.Claim;
import com.example.claim_service.ClaimDTO;
import com.example.claim_service.ReportDTO;

import java.util.ArrayList;
import java.util.List;

public class ClaimDAO extends DAO {

    public ClaimDAO() {
        databaseName = "insurance_system";
        tableName = "claim";
    }

    public List<Claim> getClaimsByStatus(Claim.Status status) {
        String sql = "select * from " + tableName + " where status=\'" + status + "\';";
        return getClaims(sql);
    }
    public List<Claim> getAllClaims() {
        String sql = "select * from "+tableName+";";
        return getClaims(sql);
    }

    public List<Claim> getClaims(String sql) {
        if (!executeQuery(sql)) return null;
        if(!next()) return null;
        List<Claim> claims = new ArrayList<>();
        do {
            ClaimDTO claimDTO = new ClaimDTO();
            claimDTO.setId(getString("id"));
            claimDTO.setCompensation(getInt("compensation"));
            claimDTO.setContract_id(getString("contract_id"));
            claimDTO.setDate(getString("date"));
            claimDTO.setDescription(getString("description"));
            claimDTO.setReport(getString("report"));
            claimDTO.setStatus(Claim.Status.valueOf(getString("status")));
            claimDTO.setInvestigator(getString("investigator"));
            claims.add(new Claim(claimDTO));
        } while(next());
        return claims;
    }

    public boolean addClaim(Claim claim) {
        String sql = "insert into " + tableName + " values(\'" + claim.getId() + "\'," + claim.getCompensation() + " , \'" + claim.getContract_id()+"\', \'"
                + claim.getDate() + "\', \'" + claim.getDescription() + "\', null , \'" + Claim.Status.REPORTING + "\', \'"+ claim.getInvestigator()+"\' );";
        return executeUpdate(sql);
    }

    public List<Claim> getClaimsByColumn(String column, String value) {
        String sql = "select * from "+tableName+" where "+column+ "= \'"+value+"\';";
        return getClaims(sql);
    }

    public boolean deleteClaim(String id) {
//        Claim claim = getClaimsByColumn("id",id).get(0);
        String sql = "delete from "+ tableName+" where id= \'"+ id+"\';";
        return executeUpdate(sql);

    }

    public boolean updateReport(ReportDTO reportDTO) {
        String sql = "update "+ tableName+ " set report = \'"+reportDTO.getReport()+"\' , status = \'"+reportDTO.getStatus().toString()+"\' , investigator= \'"+reportDTO.getInvestigator()+"\' where id= \'" +reportDTO.getId()+"\';";
        return executeUpdate(sql);
    }
//
//    public boolean updateClaim(Claim claim) {
//        String sql = "update " + tableName + " set report=\'" + claim.report + "\', compensation="
//                + claim.compensation + ", status=\'" + claim.status + "\', reviewer=\'" + claim.reviewer + "\' where id=\'" + claim.id + "\';";
//        return executeUpdate(sql);
//    }
}
