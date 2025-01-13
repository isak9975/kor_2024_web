package main.day61;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //@어노테이션,스티커 //해당 클래스는 엔티티로 사용하겠다는 표시
        //이 클래스가 JPA 엔티티로 표시
public class BoardEntity {

    //1. 멤버변수
    @Id
    private int bno;             //-게시물 번호
    @Column
    private String btitle;       //-게시물 제목
    @Column
    private String bcontent;     //-게시물 내용
    //2. 생성자

    //3. 메소드

}//end class
