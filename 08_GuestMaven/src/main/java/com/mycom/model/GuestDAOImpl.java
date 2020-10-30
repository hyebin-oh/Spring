package com.mycom.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mapper.GuestMapper;
import com.mycom.vo.GuestVO;

@Repository
public class GuestDAOImpl implements GuestDAO{
	@Autowired
	private GuestMapper mapper;

	@Override
	public void dao_insert(GuestVO guest) {
		mapper.insert(guest);
	}

	@Override
	public List<GuestVO> dao_list(HashMap<String, Object> hm) {		
		return mapper.list(hm);
	}

	@Override
	public int dao_count(HashMap<String, Object> hm) {
		return mapper.count(hm);
	}

	@Override
	public GuestVO dao_findById(int num) {
		return mapper.view(num);
	}

	@Override
	public void dao_update(GuestVO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_delete(int num) {
		mapper.delete(num);
		
	}
	
}
