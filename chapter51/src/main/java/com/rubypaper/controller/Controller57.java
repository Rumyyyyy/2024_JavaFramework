package com.rubypaper.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.dto.BookDTO;

public class Controller57 {
	@GetMapping("/form57.html")
	public String getmain() {
		
		return "/post/form57.html";
	}
	@PostMapping("/view57.html")
	public String postmain(BookDTO bookDTO, Model model) {
		model.addAttribute("header","책정보 전달");
		System.out.println(bookDTO.getTitle());
		System.out.println(bookDTO.getAuthor());
		System.out.println(bookDTO.getPublisher());
		System.out.println(bookDTO.getPrice());
		return "/post/view57.html";
	}
}
