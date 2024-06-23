package com.shop;

import com.shop.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        userService.registerUser(username, password, email);
        return "회원가입이 완료되었습니다.";
    }

    @PostMapping("/api/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        boolean loggedIn = userService.loginUser(username, password);
        if (loggedIn) {
            return "로그인 성공!";
        } else {
            return "로그인 실패: 유저 정보를 확인해주세요.";
        }
    }
}
