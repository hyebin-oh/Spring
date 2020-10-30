package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PersonDAOImpl implements PersonDAO{
	
	private JdbcTemplate template;
	

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//�߰��ϱ�
	public void personInsert(PersonDTO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {
			person.getId(),
			person.getName(),
			person.getPassword(),
			person.getGender(),
			person.getJob()
		};
		template.update(sql, param);		
	}

	//��ü����
	public List<PersonDTO> findAll() {
		String sql = "select * from person";
		List<PersonDTO> personList = template.query(sql, new RowMapper<PersonDTO>() {//resultSet�� ó�����ִ� �����

			@Override
			public PersonDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonDTO user = new PersonDTO();
				user.setGender(rs.getString("gender"));
				user.setId(rs.getString("id"));
				user.setJob(rs.getString("job"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}			
		});				
		return personList;
	}

	//수정하기
	public void personUpdate(PersonDTO person) {
		String sql = "update person set name=?, password=?, gender=?, job=? where id=?";
		Object[] param = new Object[] {
				person.getName(),
				person.getPassword(),
				person.getGender(),
				person.getJob(),
				person.getId()
			};		
		template.update(sql, param);	
	}

	//삭제하기
	public void personDelete(String id) {
		String sql = "delete from person where id='"+id+"'";
		template.update(sql);			
	}

	//상세보기
	public PersonDTO findByID(String id) {
		String sql = "select * from person where id='"+id+"'";
		PersonDTO person = template.queryForObject(sql, new RowMapper<PersonDTO>() {

			@Override
			public PersonDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonDTO user = new PersonDTO();
				user.setGender(rs.getString("gender"));
				user.setId(rs.getString("id"));
				user.setJob(rs.getString("job"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}			
		});		
		return person;
	}
}
