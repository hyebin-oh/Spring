package com.myperson.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{
	@Autowired
	private SqlSessionFactory sqlMapper;

	@Override
	public void dao_personInsert(String sql_ID, PersonVO person) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.insert(sql_ID,person);
		session.commit();		
	}

	@Override
	public List<PersonVO> dao_personList(String sql_ID, HashMap<String, String> hm) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		List<PersonVO> list = session.selectList(sql_ID, hm);
		return list;
	}

	@Override
	public PersonVO dao_personView(String sql_ID, String id) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		PersonVO person = session.selectOne(sql_ID, id);
		return person;
	}

	@Override
	public void dao_personUpdate(String sql_ID, PersonVO person) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.update(sql_ID, person);
		session.commit();
	}

	@Override
	public void dao_personDelete(String sql_ID, String id) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		session.update(sql_ID, id);
		session.commit();
	}
	
	public int dao_personCount(String sql_ID) {
		SqlSession session = sqlMapper.openSession(ExecutorType.REUSE);
		int count = session.selectOne(sql_ID);
		return count;
	}

}
