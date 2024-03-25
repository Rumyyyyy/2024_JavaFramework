package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
// 단순요청
	@GetMapping("/main")
	public String add() { // 제약 없음
		return "/main/main";
	}
	@RequestMapping("/home")
	public String home() {
		return "/post/home";
	}
	@RequestMapping("/userInfo")
	public String userInfo() {
		return"/user/userInfo";
	}
	
	// 데이터 전달 요청
	@GetMapping("/userdata")
	public String userdata(Model model) { // 데이터 주머니
		model.addAttribute("username", "홍길동");
		model.addAttribute("good", "빠밤~");
		return "/user/userdata";
	}
	@GetMapping("/userid")
	public String userid(@RequestParam String userid, Model model) {
		model.addAttribute("userid",userid);
		return "/user/userid";
	}
}
