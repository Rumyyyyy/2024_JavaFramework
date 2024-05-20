package com.rubypaper.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Data
@Entity
public class Board {
	@Id	// pk
	@GeneratedValue	// 자동 1씩 증가
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate;
	private int cnt;
	private String password;
	
	// Getter/Setter
}
