package com.myperson.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAOImpl dao;

	@Override
	public void personInsert(PersonVO person) {
		dao.dao_personInsert("personInsert", person);
		
	}

	@Override
	public List<PersonVO> personList(HashMap<String, String> hm) {
		return dao.dao_personList("personList", hm);
	}

	@Override
	public PersonVO personView(String id) {
		return dao.dao_personView("personView", id);
	}

	@Override
	public void personUpdate(PersonVO person) {
		dao.dao_personUpdate("personUpdate", person);
	}

	@Override
	public void personDelete(String id) {
		dao.dao_personDelete("personDelete", id);
	}
	
	public int personCount() {
		return dao.dao_personCount("personCount");
	}
}
