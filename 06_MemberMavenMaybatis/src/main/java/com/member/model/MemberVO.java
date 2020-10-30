package com.member.model;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String name;
	private String pass;
	private String reg_date;
	private String addr;
	private String memo;
}
