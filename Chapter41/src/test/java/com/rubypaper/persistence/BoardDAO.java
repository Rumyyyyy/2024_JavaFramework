package com.rubypaper.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubypaper.domain.Board;

@Repository
public class BoardDAO {
	@Autowired
	// 자동 실행 시켜주는 마이바티스 컨테이너
	private SqlSessionTemplate mybatis; // 컨테이너
	public void insertBoard(Board board) {
		mybatis.insert("insertBoard", board);
	}
	
	public List<Board> getBoardList(){
		return mybatis.selectList("getBoardList");
	}
}
