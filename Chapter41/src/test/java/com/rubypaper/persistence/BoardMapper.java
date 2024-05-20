package com.rubypaper.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rubypaper.domain.Board;

@Mapper
public interface BoardMapper { // 구현 클래스가 없어도 됨, 마이바티스가 해결
	// 삽입
	@Insert("insert into board(seq, title, writer, content) values("
			+ "(select nvl(max(seq), 0)+1 from board), "
			+ "#{title}, #{writer}, #{content})")
	public void insertBoard(Board board);
	
	// 조회
	@Select("select * from board order by seq desc")
	public List<Board> getBoardList();
}
