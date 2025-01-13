package main.day62.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
//1. 해당 클래스를 DB의 테이블과 매핑 하겠다는 어노테이션
//@Table (name="board") : 엔티티와 매핑된 테이블명을 정의
//        -> 생략할 경우 자동으로 테이블명이 정해진다.

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
//롬복 어노테이션
public class BoardEntity {

    @Id //1. 해당 필드/속성의 제약조건에 primary key 정의하는 어노테이션.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //1. mysql 의 auto_increment 의 제약조건과 동일한 어노테이션
    private int bno;

    @Column(columnDefinition = "varchar(100)",nullable = false)
    private String btitle;

    @Column(columnDefinition = "longtext", nullable = false)
    private String bcontent;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String bwriter;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String bpwd;

}
