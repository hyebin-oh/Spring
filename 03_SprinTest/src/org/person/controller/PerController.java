package org.person.controller;

import java.util.List;

import org.person.model.PersonServiceImpl;
import org.person.model.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerController {
	@Autowired
	PersonServiceImpl service;

	//추가폼으로
	@RequestMapping(value="personInsert.go", method=RequestMethod.GET)
	public String insert() {
		return "personForm";
	}
	
	//추가하기
	@RequestMapping(value="personInsert.go", method=RequestMethod.POST)
	public String insert(PersonVO person) {
		service.person_insert(person);
		return "redirect:list.go";
	}
	
	//전체보기
	@RequestMapping("list.go")
	public String list(Model model) {
		//서비스 콜
		List<PersonVO> list = service.person_list();
		model.addAttribute("userlist", list);
		return "list";
	}
	
	//상세보기, 수정
	@RequestMapping(value={"view.go","update.go"})
	public void view(Model model, String id) { //보이드는 url 패턴 그대로 jsp로 넘어감
		PersonVO person = service.person_detail(id);
		model.addAttribute("user", person);
	}

	
	//수정하기
	@RequestMapping(value="update.go", method=RequestMethod.POST)
	public String update(PersonVO person) {
		service.person_update(person);
		return "redirect:list.go";
	}
	
	//삭제하기
	@RequestMapping("delete.go")
	public String delete(String id) {
		service.person_delete(id);
		return "redirect:list.go";
	}
}
