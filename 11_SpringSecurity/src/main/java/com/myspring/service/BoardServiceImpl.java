package com.myspring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.dto.BoardDTO;
import com.myspring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper bMapper;

	@Override
	public int insert(BoardDTO board) {
		return bMapper.insert(board);
	}

	@Override
	public List<BoardDTO> findAll() {
		// TODO Auto-generated method stub
		return bMapper.list();
	}

	@Override
	public BoardDTO findByNum(int num) {
		// TODO Auto-generated method stub
		return bMapper.view(num);
	}

	@Override
	public void update(BoardDTO board) {
		bMapper.update(board);
		
	}

	@Override
	public void delete(int num) {
		bMapper.delete(num);
		
	}
}
