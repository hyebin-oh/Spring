package com.mycom.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private JdbcTemplate template;

	@Override
	public void dao_insert(Member member) {
		String sql = "insert into springmember values(?,?,?,?,?,sysdate)";
		Object[] param = new Object[] {
			member.getId(),
			member.getPass(),
			member.getName(),
			member.getAddr(),
			member.getMemo()
		};
		template.update(sql, param);
	}

	@Override
	public List<Member> dao_list(String field, String word) {
		String sql ="";
		if(word.equals("")) {//검색안함
			sql = "select * from springmember";
		}else {//검색함
			sql = "select * from springmember where "+field+" like '%"+word+"%'";
		}

		List<Member> list = template.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setAddr(rs.getString("addr"));
				member.setId(rs.getString("id"));
				member.setMemo(rs.getString("memo"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}			
		});
		return list;
	}

	@Override
	public Member dao_findById(String id) {
		String sql = "select * from springmember where id='"+id+"'";
		Member member = template.queryForObject(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member m = new Member();
				m.setAddr(rs.getString("addr"));
				m.setId(rs.getString("id"));
				m.setMemo(rs.getString("memo"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
				m.setReg_date(rs.getString("reg_date"));
				return m;
			}			
		});
		return member;
	}

	@Override
	public void dao_update(Member member) {
		String sql = "update springmember set pass=?, name=?, addr=?, memo=? where id=?";
			Object[] param = new Object[] {					
				member.getPass(),
				member.getName(),
				member.getAddr(),
				member.getMemo(),
				member.getId()
			};
			template.update(sql, param);
	}

	@Override
	public void dao_delete(String id) {
		String sql = "delete from springmember where id='"+id+"";
		template.update(sql);		
	}


}
