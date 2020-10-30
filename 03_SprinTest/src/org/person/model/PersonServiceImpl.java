package org.person.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonDAOImpl dao;

	@Override
	public void person_insert(PersonVO person) {
		dao.personInsert(person);		
	}

	@Override
	public void person_update(PersonVO person) {
		dao.personUpdate(person);		
	}

	@Override
	public void person_delete(String id) {
		dao.personDelete(id);		
	}

	@Override
	public List<PersonVO> person_list() {
		return dao.personList();
	}

	@Override
	public PersonVO person_detail(String id) {
		return dao.personDetail(id);
	}

}
