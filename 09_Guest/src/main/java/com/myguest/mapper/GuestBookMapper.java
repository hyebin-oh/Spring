package com.myguest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.myguest.model.GuestBookDTO;

public interface GuestBookMapper {

	//추가
	public void insert(GuestBookDTO gb);
	
	//전체보기
	public List<GuestBookDTO> list(HashMap<String, Object> hm);
	
	//갯수
	public int count(HashMap<String, Object> hm);
	
	//상세보기
	public GuestBookDTO view(int num);
	
	//수정
	public void update(GuestBookDTO gb);
	
	//삭제
	@Delete("delete from guestbook where num=#{num}")
	public void delete(int num);
}
