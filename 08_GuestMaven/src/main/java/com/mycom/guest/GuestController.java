package com.mycom.guest;

import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.model.GuestService;
import com.mycom.util.pageAction;
import com.mycom.vo.GuestVO;

@Controller
public class GuestController {
	@Autowired
	private GuestService service;
	
	@Autowired
	private pageAction page;

	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("gInsert")
	public String inset(HttpServletRequest req, GuestVO guest) {
		guest.setIpaddr(req.getRemoteAddr());
		service.insert(guest);
		return "redirect:gList";
	}
	
	@GetMapping("gList")
	public String list(Model model, String pageNum, String field, String word) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);			
		
		//갯수
		int count = service.count(hm);
		
		//페이징
		int pageSize =5;//한 화면에 보여지는 수
		if(pageNum==null) pageNum="1";
		
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word); //[이전]456[다음]
		
		//리스트
		List<GuestVO> list = service.list(hm);	
		
		model.addAttribute("guestlist", list);
		model.addAttribute("pageHtml", pageHtml);		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	//상세보기
	@GetMapping(value="gView",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String view(int num) {
		GuestVO guest = service.findById(num);
		JSONObject obj = new JSONObject();
		obj.put("name", guest.getName());
		obj.put("content", guest.getContent());
		obj.put("grade", guest.getGrade());
		obj.put("ipaddr", guest.getIpaddr());
		obj.put("created", guest.getCreated());

		return obj.toString();		
	}	
	
	//삭제하기
	@GetMapping(value="gDelete")
	public String delete(int num) {
		service.delete(num);
		return "redirect:list";
	}
	
	//수정하기
}
