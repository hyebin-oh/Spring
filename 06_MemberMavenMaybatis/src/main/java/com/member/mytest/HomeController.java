package com.member.mytest;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.member.model.MemServiceImpl;
import com.member.model.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
	private MemServiceImpl service;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//추가폼으로
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "insert";
	}
	
	//추가하기
	@PostMapping("insert")
	public String insert(MemberVO member) {
		service.memInsert(member);
		return "redirect:list";
	}	
	
	@GetMapping("list")
	//@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(Model model,
			@RequestParam(value="field", required = false)String field, 
			@RequestParam(value="word", required = false)String word){
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<MemberVO> list = service.memList(hm);
		model.addAttribute("list",list);
	}
	
	@GetMapping({"view","update"})
	public void view(Model model, String id) {
		MemberVO member = service.memView(id);
		model.addAttribute("member", member);
	}
	
	@PostMapping("update")
	public String update(MemberVO member) {
		service.memUpdate(member);
		return "redirect:list";
	}
	
	@GetMapping("delete")
	public String delete(String id) {
		service.memDelete(id);
		return "redirect:list";
	}
}
