package com.myspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.myspring.dto.CommentDTO;

public interface CommentMapper {
	
	@Insert("insert into commentspringboard "
			+ "values(commentspringboard_seq.nextval,#{userid},#{content},sysdate,#{bnum} )")
	public void insert(CommentDTO comment);
	
	public List<CommentDTO> list(int bnum);
	
	public void delete(int cnum);

}
