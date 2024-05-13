package com.rubypaper.persistence;

import org.springframework.stereotype.Repository;

@Repository // 저장소의 의미
public class BoardDAO {
	public BoardDAO() {
		System.out.println("~~~~>BoardDAO");
	}
}
