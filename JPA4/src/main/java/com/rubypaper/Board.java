package com.rubypaper;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Data  //setter/getter
@Entity  //db의 엔티티(객체)
// @Table(name = "BoardT")
@SequenceGenerator(name = "board_seq2" , sequenceName = "Board_Sequence" , 
				initialValue = 1, allocationSize=1)
public class Board { // JPA 컨테이너
	@Id              //pk
	@GeneratedValue // (strategy = GenerationType.SEQUENCE, // INDENTITY mysql
					 // generator = "board_seq2")  //1씩 자동증가
	 private int seq;
	@Column (unique = true)
	 private String title;
	 private String writer;
	 private String content;
	 @Temporal(TemporalType.DATE)
	 private Date createDate;
	 private int cnt;
	 @Transient
	 private String hint;
}
