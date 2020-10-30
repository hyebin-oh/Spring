package com.member.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemDAOImpl implements MemDAO{

	@Autowired
	private SqlSessionFactory sqlMapper;
	
	@Override
	public void dao_memInsert(String sql_Id, MemberVO member) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.insert(sql_Id, member);
		session.commit();		
	}

	@Override
	public List<MemberVO> dao_memList(String sql_Id, HashMap<String, String> hm) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> list = session.selectList(sql_Id, hm);
		return list;
	}

	@Override
	public MemberVO dao_memView(String sql_Id, String id) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO member = session.selectOne("memView", id);
		return member;
	}

	@Override
	public void dao_memUpdate(String sql_Id, MemberVO member) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.update("memUpdate", member);
		session.commit();		
	}

	@Override
	public void dao_memDelete(String sql_Id, String id) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.delete("memDelete", id);
		session.commit();		
	}

}
