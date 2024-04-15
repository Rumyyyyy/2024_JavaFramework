package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.dto.FriendDTO;

@Controller
public class Controller5 {
	@GetMapping("/form5")
	public String insertFriend(Model model) {
		model.addAttribute("friendDTO",new FriendDTO());
		return "/post/form5";
	}
	
	@PostMapping("/view5")
	public String friendview(FriendDTO friendDTO, Model model) {
		model.addAttribute("heading", "friends information");
		return "/post/view5";
	}
}
