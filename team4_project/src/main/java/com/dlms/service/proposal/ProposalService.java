package com.dlms.service.proposal;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.ProposalVO;

public interface ProposalService {

	List<ProposalVO> getProposalList()throws SQLException;
	ProposalVO getDetailProposalList(int proposal_num)throws SQLException;
	void writer(ProposalVO proposal)throws SQLException;
	void modify(ProposalVO proposal)throws SQLException;
	void remove(int proposal_num)throws SQLException;
}
