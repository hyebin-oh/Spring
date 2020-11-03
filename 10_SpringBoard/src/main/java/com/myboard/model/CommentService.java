package com.myboard.model;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentService {
	//추가
	public void insert(CommentDTO comment);
	
	//전체 리스트
	public List<CommentDTO> getList(int bnum);

	public void delete(int cnum);
}
