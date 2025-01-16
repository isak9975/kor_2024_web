package main.day62.controller;

import main.day62.model.entity.BoardEntity;
import main.day62.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//MVC 컴포넌트 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 생성한다.
    //1. 사용자가 보내는 HTTP 요청은 모두 Controller 에서 찾는다 (HTTP 의 요청이 오고 응답이 가는곳)
public class BoardController {
    // 싱글톤 X : 스프링은 자도응로 빈(인스턴스)를 생성하고 관리를 해준다. 개발자가 인스턴스 관리를 위임하다. IOC
    @Autowired private BoardService boardService;
        //규칙 : 컴트롤러에서 리포지토리/엔티티 객체를 사용하면 안된다.
    //C : @PostMapping / R : @GetMapping / U : @PutMapping / D : @DeleteMapipng
    //1. @RequestBody :   / 2. @RequestParam :



    //C : 게시물 쓰기
    @PostMapping("/write")
    public boolean write(@RequestBody BoardEntity boardEntity){
        return boardService.write(boardEntity);
    }

    //R : 게시물 전체 조회
    @GetMapping("/printAll")
    public List<BoardEntity> printAll(){
        return boardService.printAll();
    }

    //R : 게시물 개별 조회
    @GetMapping("/print")
    public BoardEntity print(@RequestParam int bno){
        return boardService.print(bno);
    }

    //U : 게시물 수정
    @PutMapping("/update")
    public boolean update(@RequestBody BoardEntity boardEntity){
        return boardService.update(boardEntity);
    }

    //D : 게시물 삭제
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int bno){
        return boardService.delete(bno);
    }


}//end class
