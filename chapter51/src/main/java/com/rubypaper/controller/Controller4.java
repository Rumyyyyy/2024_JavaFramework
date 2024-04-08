package com.rubypaper.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.dto.UserDTO;

public class Controller4 {
	@GetMapping("/form4.html")
	public String getmain() {
		
		return "/post/form4.html";
	}
	@PostMapping("/view4.html")
	public String postmain(UserDTO userDTO, Model model) {
		model.addAttribute("heading","object 전달");
		return "/post/view4.html";
	}
}
