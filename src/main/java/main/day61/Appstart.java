package main.day61;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Appstart {
    public static void main(String[] args) {
        SpringApplication.run(Appstart.class);

        //(1) BoardEntity 클래스로 인스턴스 생성
            //new BoardEntity() => 인스턴스 ==인스턴스1==
        BoardEntity boardEntity = new BoardEntity();
            //new BoardEntity() => 인스턴스 ==인스턴스2==
        BoardEntity boardEntity1 = new BoardEntity();
            //하나의 클래스 두개의 인스턴스
    }
}
