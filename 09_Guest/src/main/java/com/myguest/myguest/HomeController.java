package com.myguest.myguest;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.myguest.model.GuestBookDTO;
import com.myguest.model.GuestBookServiceImpl;
import com.myguest.model.GuestListVO;
import com.myguest.model.PageAction;

@Controller
public class HomeController {
	@Autowired
	private GuestBookServiceImpl service;
	
	@Autowired
	private PageAction page;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "insert";
	}
	
	
	
	@GetMapping("gList")
	@ResponseBody //객체형
	public GuestListVO list(String pageNum, String field, String word) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count=service.countGuest(hm);
		
		//한 화면에 보여지는 수
		int pageSize = 5;
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		if(endRow>count) endRow=count;
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
				
		List<GuestBookDTO> list = service.list(hm);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		GuestListVO listvo = new GuestListVO(count, list, pageHtml);
		
		return listvo; //객체형 리턴!
	}
	
	@GetMapping({"view","update"})
	@ResponseBody
	public GuestBookDTO view(int num) {
		GuestBookDTO guest = service.findByNum(num);		
		return guest; 		
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(int num) {
		service.deleteGuest(num);
		return "success";
	}
	
}
