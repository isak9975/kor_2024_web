package main.day64.JPA연관관계.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@ToString@Builder

@Entity //해당 클래스는 db 테이블과 매핑
@Table(name="member")
public class MemberEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int mno; //회원번호

    @Column(columnDefinition = "varchar(50)",unique = true)
    private String mid; //회원아이디

    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String mpwd; //회원비밀번호

    @Column(columnDefinition = "varchar(30)", nullable = false )
    private String mname; //회원이름

    @Column(columnDefinition = "varchar(50)", unique = true,nullable = false)
    private String memail; //회원 이메일

    //양방향 : 데이터 베이스에서 지원하지 않지만, ORM 에서 지원한다.
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 하나(PK)가 다수(FK)에게 1:M
    //mappedBy = "단방향멤버변수" : 자바에서만 양방향을 사용하겠다는 설정
    @ToString.Exclude // 양방향에서 순환 참조를 대비 하기 위한 toString 사용 제외.
    @Builder.Default // 빌더 패턴 사용시 자동으로 초기값을 주입하는 어노테이션
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    //양방향
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude@Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();

}
