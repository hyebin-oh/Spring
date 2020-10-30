package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PerDAOImpl implements PerDAO{
	
	@Autowired
	private JdbcTemplate template;


	@Override
	public void perInsert(Person p) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {
				p.getId(),
				p.getName(),
				p.getPassword(),
				p.getGender(),
				p.getJob()
		};
		template.update(sql, param);
	}

	@Override
	public List<Person> perList() {
		String sql = "select * from person";
		List<Person> list = template.query(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int arg1) throws SQLException {
				Person p = new Person();
				p.setGender(rs.getString("gender"));
				p.setId(rs.getString("id"));
				p.setJob(rs.getString("job"));
				p.setName(rs.getString("name"));
				p.setPassword(rs.getString("password"));
				return p;
			}
			
		});
		return list;
	}

	@Override
	public void perUpdate(Person p) {
		String sql = "update person set name=?, password=?, gender=?, job=? where id=? ";
		Object[] param = new Object[] {
				p.getName(),
				p.getPassword(),
				p.getGender(),
				p.getJob(),
				p.getId()
		};
		template.update(sql, param);
		
	}

	@Override
	public void perDelete(String id) {
		String sql = "delete from person where id='"+id+"'";
		template.update(sql);
		
	}

	@Override
	public Person perView(String id) {
		String sql = "select * from person where id='"+id+"'";
		Person person = template.queryForObject(sql, new RowMapper<Person>() {
			
			public Person mapRow(ResultSet rs, int arg1) throws SQLException {
				Person user = new Person();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));				
				user.setJob(rs.getString("job"));				
				return user;
			}			
		});		
		return person;
	}

}
