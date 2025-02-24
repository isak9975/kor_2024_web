package main.day64.객체연관관계;

import lombok.*;

import java.util.List;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class 댓글 {

    private int 댓글번호;
    private String 댓글내용;

    //단뱡향 : 댓글 ---> 회원
    private 회원 댓글작성자FK;
    //단방향 : 댓글 ---> 게시물
    private 게시물 게시물번호FK;
}
