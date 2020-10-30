package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.person.model.PerDAOImpl;
import com.person.model.Person;

@Controller
public class PersonController {
	@Autowired
	private PerDAOImpl dao;

	//추가폼으로
	//메소드를 추가할 때는 매핑주소에 value를 추가
	@RequestMapping(value="personInsert.go", method=RequestMethod.GET)
	public String  insert() {
		return "personForm";
	}
	
	//추가
	@RequestMapping(value="personInsert.go", method=RequestMethod.POST)
	public String insert(Person p) {
		dao.perInsert(p);
		
		return "redirect:list.go";	
	}
	
	//리스트
	@RequestMapping(value="list.go", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<Person> list = dao.perList();
		mv.addObject("userlist", list);
		mv.setViewName("list");
		return mv;
	}
	
	//상세보기
	@RequestMapping("view.go")
	public ModelAndView view(String id) {
		Person p = dao.perView(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", p);
		mv.setViewName("view");
		return mv;
		
	}
	
	//수정 폼으로
	@RequestMapping(value="update.go", method=RequestMethod.GET)
	public String update(Model model, String id) {
		Person p = dao.perView(id);
		model.addAttribute("user", p);
		return "updateForm";
	}
	/*public ModelAndView updateForm(String id) {
		Person p = dao.perView(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", p);
		mv.setViewName("updateForm");
		return mv;
	}
	*/
	
	//수정하기
	@RequestMapping(value="update.go", method=RequestMethod.POST)
	public String update(Person p) {
		dao.perUpdate(p);
		return "redirect:list.go";
	}
	
	//삭제하기
	@RequestMapping("delete.go")
	public String delete(String id) {
		dao.perDelete(id);
		return "redirect:list.go";
	}
	
}
