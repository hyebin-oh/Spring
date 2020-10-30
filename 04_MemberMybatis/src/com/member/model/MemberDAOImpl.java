package com.member.model;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionFactory sqlMapper;
	
	@Override
	public void dao_insert(String sql_Id, MemberVO member) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.insert(sql_Id, member);//sql_Id="insertData"
		session.commit();		
	}

	@Override
	public List<MemberVO> dao_list(String sql_Id) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> list = session.selectList(sql_Id);
		return list;
	}

	@Override
	public MemberVO dao_view(String sql_Id, String id) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO member = session.selectOne("viewData", id);
		return member;
	}

	@Override
	public void dao_update(String sql_Id, MemberVO member) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.update("updateData", member);
		session.commit();		
	}

	@Override
	public void dao_delete(String sql_Id, String id) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.delete("deleteData", id);
		session.commit();		
	}	

}
