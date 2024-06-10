package com.rubypaper;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
@SpringBootTest
public class BoardRepositoryTest{
	@Autowired
	private BoardRepository boardRepo;
	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("first title ---");
		board.setWriter("kim malja");
		board.setContent("Is it well written?");
		board.setCreateDate(new Date());
		board.setCnt(0);
		boardRepo.save(board);
	}
}
