package com.myperson.person;

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

import com.myperson.model.PersonServiceImpl;
import com.myperson.model.PersonVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private PersonServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "personInsert";
	}
	
	@PostMapping("personInsert")
	public String personInsert(PersonVO person) {
		service.personInsert(person);
		return "redirect:personList";
	}
	
	@GetMapping("personList")
	public void personList(Model model, String field, String word){
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<PersonVO> list = service.personList(hm);
		model.addAttribute("userlist", list);
		
		int count = service.personCount();
		model.addAttribute("userCount", count);		
	}
	
	@GetMapping({"personView","personUpdate"})
	public void personView(Model model, String id) {
		PersonVO person = service.personView(id);
		model.addAttribute("user", person);		
	}
	
	@PostMapping("personUpdate")
	public String personUpdate(PersonVO person) {
		service.personUpdate(person);
		return "redirect:personList";
	}
	
	@GetMapping("personDelete")
	public String personDelete(String id) {
		service.personDelete(id);
		return "redirect:personList";
	}	
}
