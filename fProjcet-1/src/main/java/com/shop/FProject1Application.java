package com.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.shop.domain.User;

@SpringBootApplication
public class FProject1Application {

    private static final Map<String, User> userDatabase = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(FProject1Application.class, args);
    }

    @Component
    public static class ConsoleRunner implements CommandLineRunner {

        @Override
        public void run(String... args) {
            while (true) {
                System.out.println("\n메뉴를 선택하세요:");
                System.out.println("1. 로그인");
                System.out.println("2. 회원가입");
                System.out.println("3. 종료");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        login();
                        break;
                    case "2":
                        signup();
                        break;
                    case "3":
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close(); // Scanner 리소스 해제
                        return;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
                }
            }
        }

        private static void login() {
            System.out.println("\n로그인을 시작합니다.");
            System.out.print("사용자명: ");
            String username = scanner.nextLine().trim();

            System.out.print("비밀번호: ");
            String password = scanner.nextLine().trim();

            User user = userDatabase.get(username);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("로그인 성공!");
                System.out.println("사용자 정보:");
                System.out.println("이름: " + user.getName());
                System.out.println("주소: " + user.getAddress());
                System.out.println("이메일: " + user.getEmail());
            } else {
                System.out.println("사용자명 또는 비밀번호가 올바르지 않습니다.");
            }
        }

        private static void signup() {
            System.out.println("\n회원가입을 시작합니다.");
            System.out.print("사용자명: ");
            String username = scanner.nextLine().trim();

            if (userDatabase.containsKey(username)) {
                System.out.println("이미 존재하는 사용자입니다.");
                return;
            }

            System.out.print("비밀번호: ");
            String password = scanner.nextLine().trim();

            System.out.print("이름: ");
            String name = scanner.nextLine().trim();

            System.out.print("주소: ");
            String address = scanner.nextLine().trim();

            System.out.print("이메일: ");
            String email = scanner.nextLine().trim();

            User newUser = new User(username, password, name, address, email);
            userDatabase.put(username, newUser);

            System.out.println("회원가입 완료!");
        }
    }
}
