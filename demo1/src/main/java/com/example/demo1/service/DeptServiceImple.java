package com.example.demo1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.dao.DeptDao;
import com.example.demo1.vo.DeptVO;

import lombok.Builder;

@Service
public class DeptServiceImple implements DeptService{

	private DeptDao deptDao;
	
	@Builder
	public DeptServiceImple(DeptDao deptDao) {
		super();
		this.deptDao=deptDao;
		// TODO Auto-generated constructor stub
	} 
	
	@Override
	public List<DeptVO> list() {
		// TODO Auto-generated method stub
		return deptDao.list();
	}

}
