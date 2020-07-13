package com.dlms.dao.proposal;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.ProposalVO;

public interface ProposalDAO {

	public List<ProposalVO> selectProposalList()throws SQLException;
	public ProposalVO selectProposalByProposal_no(int proposal_num)throws SQLException;
	void insertProposal(ProposalVO proposal)throws SQLException;
	void updateProposal(ProposalVO proposal)throws SQLException;
	void deleteProposal(int proposal_num)throws SQLException;
	int selectProposalSeqNext()throws SQLException;
	
}
