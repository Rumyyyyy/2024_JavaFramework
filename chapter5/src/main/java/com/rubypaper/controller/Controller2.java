package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller2 {
    @GetMapping("/home")
	public String home() {
		
		return "home";
	}
}
