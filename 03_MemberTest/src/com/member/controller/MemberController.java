package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAOImpl dao;
	
	//추가폼으로
	@RequestMapping(value="member_insert.me", method=RequestMethod.GET)
	public String insert() {
		return "memberInsert";
	}
	
	//추가
	@RequestMapping(value="member_insert.me", method=RequestMethod.POST)
	public String insert(MemberDTO user) {
		dao.insert(user);
		return "redirect:member_list.me";		
	}
	
	//전체보기
	@RequestMapping(value="member_list.me", method=RequestMethod.GET)
	public String list(Model model) {
		List<MemberDTO> list = dao.getMemberList();
		model.addAttribute("list", list);
		return "memberList";
	}
	
	//상세보기
	@RequestMapping("member_view.me")
	public String view(Model model, String id) {
		MemberDTO member = dao.findById(id);
		model.addAttribute("member", member);
		return "memberView";
	}
	
	//수정하기 폼으로
	@RequestMapping(value="member_update.me", method=RequestMethod.GET)
	public String updateForm(Model model, String id) {
		MemberDTO member = dao.findById(id);
		model.addAttribute("member", member);
		return "memberUpdate";
	}
	
	//수정하기
	@RequestMapping(value="member_update.me", method=RequestMethod.POST)
	public String update(MemberDTO user) {
		dao.update(user);
		return "redirect:member_list.me";
	}
	
	//삭제하기
	@RequestMapping("member_delete.me")
	public String delete(String id) {
		dao.delete(id);
		return "redirect:member_list.me";
	}
}
