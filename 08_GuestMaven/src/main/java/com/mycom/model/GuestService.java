package com.mycom.model;

import java.util.HashMap;
import java.util.List;

import com.mycom.vo.GuestVO;

public interface GuestService {
	//추가하기
	public void insert(GuestVO guest);
	
	//전체보기
	public List<GuestVO> list(HashMap<String, Object> hm);
	
	//갯수
	public int count(HashMap<String, Object> hm);
	
	//상세보기
	public GuestVO findById(int num);
	
	//수정하기
	public void update(GuestVO guest);
	
	//삭제하기
	public void delete(int num);
}
