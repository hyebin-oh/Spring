package com.myspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.dto.CommentDTO;
import com.myspring.service.CommentService;

@RequestMapping("/reply/*")
@RestController
public class CommentController {
	
	@Autowired
	private CommentService cService;
	
	@PostMapping("/commentInsert")
	public String cInsert(@RequestBody CommentDTO comment) {
		cService.commentInsert(comment);
		return "success";
	}

}
