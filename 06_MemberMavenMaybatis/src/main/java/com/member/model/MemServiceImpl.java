package com.member.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemServiceImpl implements MemService{

	@Autowired
	private MemDAOImpl dao;
	
	@Override
	public void memInsert(MemberVO member) {
		dao.dao_memInsert("memInsert",member);		
	}

	@Override
	public List<MemberVO> memList(HashMap<String, String> hm) {
		return dao.dao_memList("memList", hm);
	}

	@Override
	public MemberVO memView(String id) {
		return dao.dao_memView("memView", id);
	}

	@Override
	public void memUpdate(MemberVO member) {
		dao.dao_memUpdate("memUpdate", member);		
	}

	@Override
	public void memDelete(String id) {
		dao.dao_memDelete("memDelete", id);		
	}

}
