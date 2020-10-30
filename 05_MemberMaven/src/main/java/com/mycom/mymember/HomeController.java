package com.mycom.mymember;

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

import com.mycom.model.Member;
import com.mycom.model.MemberService;
import com.mycom.model.MemberServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private MemberServiceImpl mService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//추가폼으로
	@GetMapping("/")
	public String home(Locale locale, Model model) {		
		return "insert";
	}
	
	//추가하기
	@PostMapping("insert")
	public String insert(Member member) {
		mService.insert(member);
		return "redirect:list";		
	}
	
	//전체보기
	@GetMapping("list")
	public void list(Model model, String field, String word) {
		field = field==null?"":field;
		word = word==null?"":word;
		List<Member> member = mService.list(field, word);
		model.addAttribute("list", member);
	}
	
	//상세보기
	@GetMapping({"view", "update"})
	public void view(Model model, String id) {
		Member member = mService.findById(id);
		model.addAttribute("member", member);
	}
	
	//수정하기
	@PostMapping("update")
	public String update(Member member) {
		mService.update(member);
		return "redirect:list";
	}
	
	//삭제하기
	@GetMapping("delete")
	public String delete(String id) {
		mService.delete(id);
		return "redirect:list";
	}

	@GetMapping("sample1")
	@ResponseBody
	public String sample() {
		return "sample1";
	}
	
}
