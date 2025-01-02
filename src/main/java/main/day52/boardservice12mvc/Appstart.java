package main.day52.boardservice12mvc;

import day52.boardservice8mvc.view.BoardView;

public class Appstart {
    public static void main(String[] args) {

        //싱글톤 내부 함수 호출
        BoardView.getInstance().run();



    }//end main

}//end Appstart
