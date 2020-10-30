package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private JdbcTemplate template;

	@Override
	//전체보기
	public List<MemberDTO> getMemberList() {
		String sql = "select * from springmember";
		List<MemberDTO> list = template.query(sql, new RowMapper<MemberDTO>(){

			@Override
			public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDTO member = new MemberDTO();
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
	//상세보기
	public MemberDTO findById(String id) {
		String sql = "select * from springmember where id='"+id+"'";
		MemberDTO member = template.queryForObject(sql, new RowMapper<MemberDTO>() {

			@Override
			public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDTO mem = new MemberDTO();
				mem.setAddr(rs.getString("addr"));
				mem.setId(rs.getString("id"));
				mem.setMemo(rs.getString("memo"));
				mem.setName(rs.getString("name"));
				mem.setPass(rs.getString("pass"));
				mem.setReg_date(rs.getString("reg_date"));
				return mem;
			}
			
		});
		return member;
	}

	@Override
	//추가
	public void insert(MemberDTO user) {
		String sql = "insert into springmember values(?,?,?,?,?,sysdate)";
		Object[] param = new Object[] {
			user.getId(), 
			user.getPass(),	
			user.getName(),
			user.getAddr(),
			user.getMemo()
		};
		template.update(sql, param);		
	}

	@Override
	//수정하기
	public void update(MemberDTO user) {
		String sql = "update springmember set pass=?, name=?, addr=?, memo=? where id=?";
		Object[] param = new Object[] {
				user.getPass(),
				user.getName(),
				user.getAddr(),
				user.getMemo(),
				user.getId()
		};
		template.update(sql, param);		
	}

	@Override
	//삭제하기
	public void delete(String id) {
		String sql = "delete from springmember where id='"+id+"'";
		template.update(sql);
		
	}

}
