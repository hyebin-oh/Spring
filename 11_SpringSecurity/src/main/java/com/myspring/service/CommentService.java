package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.dto.CommentDTO;
import com.myspring.mapper.CommentMapper;

@Service
public class CommentService {

	@Autowired
	private CommentMapper cMapper;
	//추가
	public void commentInsert(CommentDTO comment) {
		cMapper.insert(comment);
	}
	
	//리스트
	public List<CommentDTO> commentList(int bnum){
		return null;
	}
	
	//삭제
	public void commentDelete(int cnum) {
		
	}
}
