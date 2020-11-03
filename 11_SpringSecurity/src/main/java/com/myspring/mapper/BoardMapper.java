package com.myspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.myspring.dto.BoardDTO;

public interface BoardMapper {
	//글쓰기
	@Insert("insert into springboard "
			+ "values(springboard_seq.nextval, #{title}, #{content},#{writer},"
			+ "sysdate, '1', #{password}, '0')")
	public int insert(BoardDTO board);
	
	@Select("select * from springboard order by num")
	public List<BoardDTO> list();
	
	@Select("select * from springboard where num=#{num}")
	public BoardDTO view(int num);
}
