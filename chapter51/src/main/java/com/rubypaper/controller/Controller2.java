package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller2 {
    @GetMapping("/home")
	public String home() {
		
		return "home";
	}
    @GetMapping("/data")
   	public String home(Model model) {
   		model.addAttribute("myname","leesunshin");
   		return "data";
   	}
    @GetMapping("/param")
   	public String param(@RequestParam("depart") String dept,
   			@RequestParam("studentno") String sno,Model model) {
   		model.addAttribute("depart",dept);
   		model.addAttribute("studentno",sno);
   		return "/param";
   	}    
    @GetMapping("/params")
   	public String params(@RequestParam("uid") String id,
   			@RequestParam("uname") String name,
   			@RequestParam("uemail") String email,
   			@RequestParam("uhp") String hp,Model model) {
   		model.addAttribute("uid",id);
   		model.addAttribute("uname",name);
   		model.addAttribute("uemail",email);
   		model.addAttribute("uhp",hp);
   		return "/params";
   	}    
    @PostMapping("/post/post")
	public String post(@RequestParam String membername,
			           @RequestParam String memberid,
			           Model model) {
		model.addAttribute("membername", membername);
		                  //    키      ,     값
		model.addAttribute("memberid",memberid);		
		return "/post/post";
    }
}
