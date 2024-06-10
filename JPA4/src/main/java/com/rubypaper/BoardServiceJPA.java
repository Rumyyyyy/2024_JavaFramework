package com.rubypaper;

import java.util.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Service
public class BoardServiceJPA implements ApplicationRunner{
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("JPA4");
		EntityManager em = emf.createEntityManager();	
		EntityTransaction tx =em.getTransaction();
		tx.begin();
			Board board = new Board();
			// board.setSeq(3);
			board.setTitle("3-1반 스프링");
			board.setWriter("kim maldong");
			board.setCreateDate(new Date());
			board.setContent("title1");
			board.setCnt(0);
			System.out.println("persist 명령 전 상태 :" +em.contains(board));
			// persist에 의해 영속상태로 이동JPA가 관리하고 있음
			em.persist(board);
			tx.commit();
			Board findBoard = em.find(Board.class, 1);
			// friendBoard = em.find(Board.class, 2);
			System.out.println("--------------------");
			System.out.println("찾은 값은 : "+findBoard.toString());
			System.out.println("find 명령 후 상태 :" +em.contains(findBoard));
			em.detach(findBoard);
			System.out.println("detach 명령 후 상태 :" +em.contains(findBoard));
			
			// friendBoard.setTitle("[title~~~]");
			Board mergeBoard = em.merge(findBoard);
			System.out.println("merge 후 findBoard는 영속 상태인가 : "+em.contains(findBoard));
			System.out.println("merge 후 mergeBoard는 영속 상태인가 : "+em.contains(mergeBoard));
			
			em.close();
			emf.close();
		// em.find 검색
		// Board board = new Board();
		// Board findBoard = em.find(Board.class, 52);
		// System.out.println("검색 결과 값 :"+findBoard.toString());
		// 삭제하기
		// em.remove(findBoard);
		
		// insert
//		EntityTransaction tx =em.getTransaction();
//		tx.begin();
		// 정보삽입
//		Board board = new Board();	
//	    board.setTitle("jpatitle3");
//	    board.setWriter("kim uhan3");
//	    board.setContent("jpa content3");
//	    board.setCreateDate(new Date());
//		board.setCnt(0);
		
//		em.persist(board);
		// 순서 중요
		// tx.commit();	
	}	
}
