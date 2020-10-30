package com.mycom.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mycom.vo.GuestVO;

public interface GuestMapper {
	
	@Insert("insert into guestbook "
			+ "values(guestbook_seq.nextval,#{name}, #{content}, #{grade},sysdate, #{ipaddr})")
	public void insert(GuestVO guest);
	
	public List<GuestVO> list(HashMap<String, Object> hm);
	
	public int count(HashMap<String, Object> hm);
	
	@Select("select * from guestbook where num=#{num}")
	public GuestVO view(int num);
	
	public void update(GuestVO guest);
	
	@Delete("delete from guestbook where num=#{num}")
	public void delete(int num);
}
