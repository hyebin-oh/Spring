package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("test.go")
	public String test() {
		//스프링에서 String은 기본적으로 jsp를 의미
		return "result";
	}

}
