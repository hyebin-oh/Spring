package com.mycom.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAOImpl mDao;
	
	@Override
	public void insert(Member member) {
		mDao.dao_insert(member);		
	}

	@Override
	public List<Member> list(String field, String word) {
		return mDao.dao_list(field, word);
	}

	@Override
	public Member findById(String id) {
		return mDao.dao_findById(id);
	}

	@Override
	public void update(Member member) {
		mDao.dao_update(member);		
	}

	@Override
	public void delete(String id) {
		mDao.dao_delete(id);		
	}


}
