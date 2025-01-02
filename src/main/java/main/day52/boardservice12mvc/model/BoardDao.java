package main.day52.boardservice12mvc.model;

import java.util.ArrayList;

public class BoardDao {
    //-싱글톤 만들기 3단계
    private BoardDao(){}
    private static BoardDao boardDao = new BoardDao();
    public static BoardDao getInstance(){return boardDao;}

    ArrayList<BoardDto> boardDb = new ArrayList<>();

        public boolean write(BoardDto boardDto){
            boardDb.add(boardDto);
            return true;
        }

        public ArrayList<BoardDto> findAll(){

            return boardDb;
        }

}//end Dao
