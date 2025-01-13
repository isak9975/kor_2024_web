package main.day61;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Appstart {

    @Autowired
    static BoardRepository boardRepository;

    public static void main(String[] args) {
        SpringApplication.run(Appstart.class);

        //(1) BoardEntity 클래스로 인스턴스 생성
            //new BoardEntity() => 인스턴스 ==인스턴스1==
        BoardEntity boardEntity = new BoardEntity(1,"안녕1","내용2");
            //new BoardEntity() => 인스턴스 ==인스턴스2==
        BoardEntity boardEntity1 = new BoardEntity(2,"안녕2","내용2");
            //하나의 클래스 두개의 인스턴스

            // 퍼시스턴트 : 영속성 JPA

        //1. 모든 엔티티 호출 함수;              .findAll()

        //2. 엔티티/인스턴스의 테이블에 저장하는 함수 -- 영속성을 부여
        boardRepository.save(boardEntity);
        boardRepository.save(boardEntity1);

        List<BoardEntity> list = boardRepository.findAll();


    }
}
