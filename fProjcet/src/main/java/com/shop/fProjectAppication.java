package com.shop;

import com.shop.domain.User;
import com.shop.domain.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class fProjectAppication {

    public static void main(String[] args) {
        SpringApplication.run(fProjectAppication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
                System.out.print("메뉴 선택: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기

                switch (choice) {
                    case 1:
                        System.out.print("사용자 이름 입력: ");
                        String username = scanner.nextLine();
                        System.out.print("비밀번호 입력: ");
                        String password = scanner.nextLine();
                        System.out.print("이메일 입력: ");
                        String email = scanner.nextLine();
                        userService.registerUser(username, password, email);
                        break;
                    case 2:
                        System.out.print("사용자 이름 입력: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("비밀번호 입력: ");
                        String loginPassword = scanner.nextLine();
                        userService.loginUser(loginUsername, loginPassword);
                        break;
                    case 3:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            }
        };
    }
}
