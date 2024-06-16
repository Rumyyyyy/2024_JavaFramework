package com.rubypaper;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Service
public class LoginServiceJPA implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Login");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       

       
        tx.commit();

        em.close();
        emf.close();
    }
}

//데이터 삽입
//
//Login login = new Login();
//login.setNo(0);
//login.setId("abc4");
//login.setPw("qwe4");
//
//em.persist(login);


//특정 id에 해당하는 로그인 정보 조회
//Login login = em.find(Login.class, 1);
// 패스워드 수정
//if (login != null) {
//  login.setPw("새로운 패스워드");
//  em.merge(login); // 수정된 엔티티를 다시 영속 상태로 변경
//}


//특정 id 삭제
//Login login = em.find(Login.class, 2); // 특정 ID를 사용하여 조회
//
//if (login != null) {
//  em.remove(login); // 엔티티 삭제
//}
