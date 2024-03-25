package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.StudentVO;
@RestController
public class Student {
	@GetMapping("/getStudentList")
	public List<StudentVO> getStudent() {
		List<StudentVO> studentlist = new ArrayList<StudentVO>();
		for(int i=1; i<=3; i++) {
			StudentVO student = new StudentVO();
			student.setSeq(i);
			student.setName("김아름");
			student.setAge(20+i+"살");
			student.setSchool("유한대학교");
			student.setCreateDate(new Date());
			student.setCnt(0);
			studentlist.add(student);
		}
		return studentlist;
	}
}
