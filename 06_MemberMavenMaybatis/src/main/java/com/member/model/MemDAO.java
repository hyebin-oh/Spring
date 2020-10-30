package com.member.model;

import java.util.HashMap;
import java.util.List;

public interface MemDAO {
	//추가하기
	public void dao_memInsert(String sql_Id, MemberVO member);
	
	//전체보기
	public List<MemberVO> dao_memList(String sql_Id, HashMap<String, String> hm);
	
	//상세보기
	public MemberVO dao_memView(String sql_Id,String id);
	
	//수정하기
	public void dao_memUpdate(String sql_Id,MemberVO member);
	
	//삭제하기
	public void dao_memDelete(String sql_Id, String id);
}
