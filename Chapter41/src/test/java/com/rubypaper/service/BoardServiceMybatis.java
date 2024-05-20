package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardDAO;

@Service
public class BoardServiceMybatis implements ApplicationRunner{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		Board board = new Board();
		board.setTitle("mybatis title");
		board.setWriter("leesunshin");
		board.setContent("This is the mybatis.");
		
		boardDAO.insertBoard(board);
		List<Board> boardList = boardDAO.getBoardList();
		for(Board row:boardList) {
			System.out.println("----->"+row.toString());
		}
	}
}
