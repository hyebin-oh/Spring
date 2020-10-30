package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	
	//추가하기 폼으로
	@RequestMapping(value="insert.my", method=RequestMethod.GET)
	public String insert() {
		return "insert";
	}
	
	//추가하기
	@RequestMapping(value="insert.my", method=RequestMethod.POST)
	public String insert(MemberVO member) {
		mService.insert(member);
		return "redirect:list.my";
	}
	
	@RequestMapping(value="list.my", method=RequestMethod.GET)
	public void list(Model model){
		List<MemberVO> list = mService.list();
		model.addAttribute("list", list);		
	}
	
	@RequestMapping(value= {"view.my","update.my"})
	public void view(Model model, String id) {
		MemberVO member = mService.view(id);
		model.addAttribute("member", member);		
	}
	
	@RequestMapping(value="update.my", method=RequestMethod.POST)
	public String update(MemberVO member) {
		mService.update(member);
		return "redirect:list.my";
	}
	
	@RequestMapping(value="delete.my", method=RequestMethod.GET)
	public String delete(String id) {
		mService.delete(id);
		return "redirect:list.my";
	}
	
}
