package com.myspring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleCont {
	@GetMapping("admin")
	public void admin() {
		
	}
	
	@GetMapping("member")
	public void member() {
		
	}

}
