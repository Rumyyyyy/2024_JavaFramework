package com.rubypaper;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data  //setter/getter
@Entity  //db의 엔티티(객체)
public class Board {
	@Id              //pk
	@GeneratedValue  //1씩 자동증가
	 private int seq;
	 private String title;
	 private String writer;
	 private String content;
	 private Date createDate;
	 private int cnt;
}
