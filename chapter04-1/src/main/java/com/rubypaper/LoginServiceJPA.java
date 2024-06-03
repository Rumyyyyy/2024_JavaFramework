package com.rubypaper;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Service
public class LoginServiceJPA implements ApplicationRunner{
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("chapter04-1");
		EntityManager em = emf.createEntityManager();	
			Login login = new Login();		
			
			Login findLogin = em.find(Login.class, 1);
			System.out.println("검색결과 : "+findLogin.toString());
			// 수정하기
			EntityTransaction tx = em.getTransaction();
			tx.begin();
//			findLogin.setNo(1);
//			findLogin.setId("aaa");
//			findLogin.setPw("a1a");
//			tx.commit();
//			System.out.println("수정결과값 : "+findLogin.toString());
			
			 //삭제하기
//			 em.remove(findLogin);
			
			// 글 목록 다 출력
			String jpq1 = "select b from Board order by b.seq desc";
			List<Login> Loginlist = em.createQuery(jpq1).getResultList();
			for(Login login1:Loginlist) {
				System.out.println("------>"+login1.toString());
			}
			tx.commit();
			
//			EntityTransaction tx =em.getTransaction();
//			tx.begin();
//			login.setNo(1);
//			login.setId("aaa");
//			login.setPw("111");
//			em.persist(login);
//			tx.commit();
			em.close();
			emf.close();	
	}	
}
