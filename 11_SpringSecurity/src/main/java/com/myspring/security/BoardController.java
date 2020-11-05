package com.myspring.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.dto.BoardDTO;
import com.myspring.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService bService;

	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	//로그인 권한이 있는지 확인, 권한이 있으면 페이지 이동, 권한 없으면 로그인창으로
	//pre 사용을 위해서는 spring/appServlet/servlet-context.xml에 pre어노테이션 사용으로 설정
	public void toInsert() {
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		bService.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public void list(Model model) {
		List<BoardDTO> list = bService.findAll();
		model.addAttribute("list", list);
	}
	
	@GetMapping("view")
	public void view(Model model, int num) {
		BoardDTO board = bService.findByNum(num);
		model.addAttribute("board", board);
	}
	
	@GetMapping("update")
	public void updateForm(Model model, int num) {
		BoardDTO board = bService.findByNum(num);
		model.addAttribute("board", board);
	}
	
	@PostMapping("update")
	public String update(BoardDTO board) {
		bService.update(board);
		return "redirect:list";
	}
	
	@GetMapping("delete")
	public String delete(int num) {
		bService.delete(num);
		return "redirect:list";
	}

}
