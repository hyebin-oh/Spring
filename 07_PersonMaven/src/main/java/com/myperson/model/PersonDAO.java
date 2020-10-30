package com.myperson.model;

import java.util.HashMap;
import java.util.List;

public interface PersonDAO {
	public void dao_personInsert(String sql_ID, PersonVO person);
	public List<PersonVO> dao_personList(String sql_ID, HashMap<String, String> hm);
	public PersonVO dao_personView(String sql_ID, String id);
	public void dao_personUpdate(String sql_ID, PersonVO person);
	public void dao_personDelete(String sql_ID, String id);
}
