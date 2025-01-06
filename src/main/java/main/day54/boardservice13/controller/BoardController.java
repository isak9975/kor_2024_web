package main.day54.boardservice13.controller;

import main.day54.boardservice13.model.dao.BoardDao;
import main.day54.boardservice13.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//[1] 클래스 위에 @RestController
@RestController // 현재 클래스에서 rest api 가 가능한 클래스임을 주입한다.
public class BoardController {

    //[2]함수 위에 @XXXMAPPING("/주소만들기")
        //->위 두 작업만 하면 웹이서 할수 있는 명령어로 만들수 있음.
    //1. 게시물 쓰기      HTTP METHOD 중에 @POST MAPPING  [ CURD 에서 C ]
    @PostMapping("/write")
    public boolean write(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        boolean result = BoardDao.getInstance().write(boardDto);
        return result;
    }

    //2. 게시물 전체 조회   HTTP METHOD 중에 @GET MAPPING  [ CURD 에서 R ]
    @GetMapping("/findAll")
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
        return result;
    }

    //3. 게시물 개별 조회 _ 누구를 조회할지 bno가 매개변수로 필요로 한다.
    @GetMapping("/findid")
    //[TEST] Talend Api Tester : [Get] http://localhost:8080/findid?bno=1

    public BoardDto findid(int bno){
        System.out.println("BoardController.findid");
        System.out.println("bno = " + bno);
        BoardDto result = BoardDao.getInstance().findid(bno);
        return result;
    }
    //4. 게시물 수정  @PUT MAPPING   [ CURD 에서 U ]
    @PutMapping("/update")
    //[TEST] Talend Api Tester :
    //  [PUT] http://localhost:8080/update
    //  [Header] Content-Type : application/json
    //  [body] {"bno":3,"btitle":"수정한제목","bcontent":"수정한내용"}

    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        boolean result = BoardDao.getInstance().update(boardDto);
        return result;
    }

    //5. 게시물 삭제  @DELETE MAPPING    [ CURD 에서 D ]
    //[TEST] Talend Api Tester : [Delete] http://localhost:8080/delete?bno=1
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        boolean result = BoardDao.getInstance().delete(bno);
        return result;
    }






//    CONSOLE 에서의 작업
//    //+싱글톤 작업
//    private static BoardController boardController = new BoardController();
//    private BoardController(){};
//    public static BoardController getInstance(){return boardController;}
//
//    //1. 게시물 쓰기      @POST MAPPING  [ CURD 에서 C ]
//    public boolean write(BoardDto boardDto){
//        boolean result = BoardDao.getInstance().write(boardDto);
//        return true;
//    }
//
//    //2. 게시물 전체 조회   @GET MAPPING  [ CURD 에서 R ]
//    public ArrayList<BoardDto> findAll(){
//        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
//        return result;
//    }
//
//    //3. 게시물 개별 조회 @GET MAPPING  [ CURD 에서 R ]
//
//    //4. 게시물 수정  @PUT MAPPING   [ CURD 에서 U ]
//
//    //5. 게시물 삭제  @DELETE MAPPING    [ CURD 에서 D ]





}
