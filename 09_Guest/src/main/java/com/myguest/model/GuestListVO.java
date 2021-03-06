package com.myguest.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class GuestListVO {
	private int count;
	private List<GuestBookDTO> list;
	private String pageHtml;
	
	//컨트롤러에서 넘겨주는 값이 3개
	@Builder
	public GuestListVO(int count, List<GuestBookDTO> list, String pageHtml) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
		
	}
}
