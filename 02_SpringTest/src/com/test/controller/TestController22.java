package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController22 {
	
	@RequestMapping("test22.go")
	public String test22() {
		return "result22"; //jsp 파일명
	}

}
