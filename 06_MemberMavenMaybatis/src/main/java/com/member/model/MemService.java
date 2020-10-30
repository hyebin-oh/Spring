package com.member.model;

import java.util.HashMap;
import java.util.List;

public interface MemService {
	//추가하기
	public void memInsert(MemberVO member);
	
	//전체보기
	public List<MemberVO> memList(HashMap<String, String> hm);
	
	//상세보기
	public MemberVO memView(String id);
	
	//수정하기
	public void memUpdate(MemberVO member);
	
	//삭제하기
	public void memDelete(String id);
}
