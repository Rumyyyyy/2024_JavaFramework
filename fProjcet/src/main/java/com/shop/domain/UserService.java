package com.shop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String username, String password, String email) {
        User newUser = new User();
        newUser.setName(username);
        newUser.setPw(password);
        newUser.setMail(email);
        
        userRepository.save(newUser);
        // 여기서는 간단하게 콘솔에 출력
        System.out.println("회원가입이 완료되었습니다.");
    }

    public boolean loginUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}
