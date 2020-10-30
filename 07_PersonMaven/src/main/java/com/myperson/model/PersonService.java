package com.myperson.model;

import java.util.HashMap;
import java.util.List;

public interface PersonService {
	public void personInsert(PersonVO person);
	public List<PersonVO> personList(HashMap<String, String> hm);
	public PersonVO personView(String id);
	public void personUpdate(PersonVO person);
	public void personDelete(String id);
}
