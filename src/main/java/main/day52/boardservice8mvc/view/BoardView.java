package main.day52.boardservice8mvc.view;

import main.day52.boardservice8mvc.controller.BoardController;
import main.day52.boardservice8mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    //-싱글톤 만들기 3단계
    private BoardView(){ }
    private static BoardView boardView = new BoardView();
    public static BoardView getInstance(){return boardView;}

    private Scanner scan = new Scanner(System.in);

    //0.메인페이지
    public void run(){
        while(true) {
            System.out.println("1. 등록, 2.출력 : ");
            int choose = scan.nextInt();
            if (choose == 1) {
                write();
            } else if (choose == 2) {
                findAll();
            }
        }
    }//end 메인페이지


    //1. 게시물 쓰기 함수
    public void write(){
        System.out.println("[ 게시물 쓰기 ]");
        System.out.println("Title : "); String title = scan.next();
        System.out.println("content : "); String content = scan.next();
        System.out.println("password : "); int pwd = scan.nextInt();

        BoardDto boardDto = new BoardDto(title,content,pwd);

        boolean result = BoardController.getInstance().write(boardDto);

        if(result){
            System.out.println("Write success");
        }
        else{
            System.out.println("Write Fail(error");
        }
    }

    //2. 게시물 출력 함수
    public void findAll(){
        System.out.println("게시물 출력");

        ArrayList<BoardDto> result = BoardController.getInstance().findAll();

        for(int index=0;index <= result.size()-1; index++){
            System.out.println("제목 : " + result.get(index).getTitle());
            System.out.println("내용 : " + result.get(index).getContent());
            System.out.println("패스워드?");
        }
    }


}//end View
