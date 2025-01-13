package main.day62.service;

import main.day62.model.entity.BoardEntity;
import main.day62.model.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//MVC 컴포넌트 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 생성한다
//1. Spring mvc 패턴에서 추가된 레이어/구역 으로 자바의 비지니스로직 담당
public class BoardService {
    //비지니스 로직이란? 기능에 실질적인 코드
        //예] 회원가입에서 타입변환, 유효성검사, 자료 가공
    @Autowired private BoardRepository boardRepository;
    //서비스는 무조건 리포지토리를 이용하여 엔티티를 조작하고 요청과 응답을 받는다
        //규칙 : 서비스에서 컨트롤러 객체를 사용하면 안된다.

    // C: 게시물 작성
    public boolean write(BoardEntity boardEntity){

        return false;
    }

    // R: 게시물 전체 출력
    public List<BoardEntity> printAll(){

        return null;
    }

    // R: 게시물 개별 출력
    public BoardEntity print(int bno){

        return null;
    }

    // U: 게시물 수정
    public boolean update(BoardEntity boardEntity){

        return false;
    }

    // D: 게시물 수정
    public boolean delete(int bno){

        return false;
    }


}//end class
