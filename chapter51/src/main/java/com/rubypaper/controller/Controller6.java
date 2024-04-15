package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.dto.BoardDTO;

@Controller
public class Controller6 {
	@GetMapping("/view6")
	public String mainPage(Model model) {
		// 단일 객체 생성
		BoardDTO boardDTO = new BoardDTO(1, "boardDTO 객체입니다.","홍길동");
		// 여러 개의 객체 생성
		BoardDTO b1 = new BoardDTO(1, "졸려","냐");
		BoardDTO b2 = new BoardDTO(2, "집 갈래","냥");
		BoardDTO b3 = new BoardDTO(3, "수업 빨리 끝나라","먕");
		BoardDTO b4 = new BoardDTO(4, "배고프다","먀");
		BoardDTO b5 = new BoardDTO(5, "웩","뮹");
		List<BoardDTO> bList = new ArrayList<>();
		bList.add(b1);
		bList.add(b2);
		bList.add(b3);
		bList.add(b4);
		bList.add(b5);
		model.addAttribute("boardDTO",boardDTO);
		model.addAttribute("bList",bList);
		return "/post/view6";
	}

}
