package com.rubypaper;

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
				Persistence.createEntityManagerFactory("JPA4");
		EntityManager em = emf.createEntityManager();	
			Login login = new Login();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			login.setNo(1);
			login.setId("aaa");
			login.setPw("111");
			em.persist(login);
			tx.commit();
			em.close();
			emf.close();

	}	
}
