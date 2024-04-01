package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller1 {
	//1
	@GetMapping("/user/data")
	public String data(Model model) {
		model.addAttribute("name","kimmaldong");
		model.addAttribute("dept","computer");
		return "/user/data";
	}
	
	//2
	@GetMapping("/user/param")
	public String param(@RequestParam("userid") String uid, String upw, Model model) {
		model.addAttribute("userid", uid);
		model.addAttribute("passwd", upw);
		return "/user/userparam";
	}
	
	//3
	@GetMapping("/user/work")
	public String work(@RequestParam("userid") String uid, String name, String email, String hp,  Model model) {
		model.addAttribute("userid", uid);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("hp", hp);
		return "/user/work";
	}
}
