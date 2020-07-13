package com.dlms.service.proposal;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dao.proposal.ProposalDAO;
import com.dlms.dto.ProposalVO;

public class ProposalServiceImpl implements ProposalService{

	private ProposalDAO proposalDAO;
	public void setProposalDAO(ProposalDAO proposalDAO) {
		this.proposalDAO = proposalDAO;
	}
	@Override
	public List<ProposalVO> getProposalList() throws SQLException {
		List<ProposalVO> proposal = proposalDAO.selectProposalList();
		
		
		return proposal;
	}

	@Override
	public ProposalVO getDetailProposalList(int proposal_num) throws SQLException {
		ProposalVO proposal = proposalDAO.selectProposalByProposal_no(proposal_num);
		return proposal;
	}

	@Override
	public void writer(ProposalVO proposal) throws SQLException {
		int proposal_num = proposalDAO.selectProposalSeqNext();
		proposal.setProposal_num(proposal_num);
		proposalDAO.insertProposal(proposal);
	}

	@Override
	public void modify(ProposalVO proposal) throws SQLException {
		proposalDAO.updateProposal(proposal);
	}

	@Override
	public void remove(int proposal_num) throws SQLException {
		proposalDAO.deleteProposal(proposal_num);
	}

}
