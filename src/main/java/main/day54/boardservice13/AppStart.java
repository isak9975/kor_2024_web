package main.day54.boardservice13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 웹 기본 세팅 주입, 웹 서버 실행
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}//end calss

//  CONSOLE 에서의 스타트
//    public static void main(String[] args) {
//        BoardView.getInstance().mainPage();
//    }

