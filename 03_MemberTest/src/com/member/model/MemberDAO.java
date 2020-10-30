package com.member.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface MemberDAO {
	//전체보기
	public List<MemberDTO> getMemberList();
	
	//상세보기
	public MemberDTO findById(String id);
	
	//추가하기
	public void insert(MemberDTO user);
	
	//수정하기
	public void update(MemberDTO user);
	
	//삭제하기
	public void delete(String id);
}
