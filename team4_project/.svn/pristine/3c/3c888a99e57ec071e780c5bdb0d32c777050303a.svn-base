package com.dlms.dao.proposal;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.ProposalVO;

public class ProposalDAOImpl implements ProposalDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<ProposalVO> selectProposalList() throws SQLException {
		List<ProposalVO> proposal = sqlSession.selectList("proposal-mapper.selectProposalList");
		return proposal;
	}
	@Override
	public ProposalVO selectProposalByProposal_no(int proposal_num) throws SQLException {
		ProposalVO proposal = sqlSession.selectOne("proposal-mapper.selectProposalByProposal_no", proposal_num);
		return proposal;
	}
	@Override
	public void insertProposal(ProposalVO proposal) throws SQLException {
		sqlSession.update("proposal-mapper.insertProposal", proposal);
	}
	@Override
	public void updateProposal(ProposalVO proposal) throws SQLException {
		sqlSession.update("proposal-mapper.updateProposal", proposal);
		
	}
	@Override
	public void deleteProposal(int proposal_num) throws SQLException {
		sqlSession.update("proposal-mapper.deleteProposal", proposal_num);
		
	}
	@Override
	public int selectProposalSeqNext() throws SQLException {
		int proposal_num = sqlSession.selectOne("proposal-mapper.selectProposalSeqNext");
		return proposal_num;
	}
}
