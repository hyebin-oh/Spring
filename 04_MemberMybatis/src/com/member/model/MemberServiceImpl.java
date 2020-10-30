package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAOImpl mDao;
	
	@Override
	public void insert(MemberVO member) {
		mDao.dao_insert("insertData", member);
	}

	@Override
	public List<MemberVO> list() {		
		return mDao.dao_list("listData");
	}

	@Override
	public MemberVO view(String id) {
		return mDao.dao_view("viewData", id);
	}

	@Override
	public void update(MemberVO member) {
		mDao.dao_update("updateData", member);		
	}

	@Override
	public void delete(String id) {
		mDao.dao_delete("deleteData", id);		
	}

}
