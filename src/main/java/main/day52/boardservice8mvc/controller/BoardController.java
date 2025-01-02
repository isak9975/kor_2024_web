package main.day52.boardservice8mvc.controller;

import main.day52.boardservice8mvc.model.BoardDao;
import main.day52.boardservice8mvc.model.BoardDto;

import java.util.ArrayList;

public class BoardController {
    private BoardController(){}
    private static BoardController boardController = new BoardController();
    public static BoardController getInstance(){return boardController;}

    //1. 게시물 쓰기 제어 함수
    public boolean write(BoardDto boardDto){
         return BoardDao.getInstance().write(boardDto);
    }//end write

    //2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> findAll(){
        return BoardDao.getInstance().findAll();
    }//end findAll

}//end class
