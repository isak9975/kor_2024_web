package main.day64.JPA연관관계.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name="reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;//댓글번호
    @Column(columnDefinition = "varchar(255)",nullable = false)
    private String rcontent; //댓글내용

    //단방향 FK : 게시물(pk) -----> 댓글(fk)
    @ManyToOne
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;

    //단방향 FK : 회원(pk) ----->댓글(fk)
    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;


}
