package com.example.demo3.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo3.model.Member;
import com.example.demo3.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("mInsert")
	public String mInsert() {
		return "insert";
	}
	
	@PostMapping("mInsert")
	public String mInsert(Member member) {
		memberService.save(member);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model, 
			@PageableDefault(size=3, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {//id를 기준으로하는 3개의 페이지 사이즈
		//List<Member> mList = memberService.list();
		Page<Member> mList = memberService.list(pageable);
		model.addAttribute("list", mList);
		return "list";
	}
	
	@GetMapping("view")
	public String view(Model model, Long id) {
		Member member = memberService.getOne(id);
		model.addAttribute("member", member);
		return "view";
	}
	
	@GetMapping("{id}")
	public String findById(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		return "view";
	}
	
	@GetMapping("delete")
	public String deleteLink(Long id) {
		memberService.delete(id);
		return "redirect:list";
	}
	
	@DeleteMapping("{id}")
	@ResponseBody
	public String deleteButton(@PathVariable Long id) {
		memberService.delete(id);
		return id.toString();
	}
}
