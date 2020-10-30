package com.person.model;

import java.util.List;

public interface PersonDAO {
	//�߰�
	public void personInsert(PersonDTO person);
	//��ü����
	public List<PersonDTO> findAll();
	//����
	public void personUpdate(PersonDTO person);
	//����
	public void personDelete(String id);	
	//�󼼺���
	public PersonDTO findByID(String id);
}