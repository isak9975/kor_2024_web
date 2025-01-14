package main.day63.model.entity;

import jakarta.persistence.*;
import lombok.*;
import main.day63.model.dto.MemberDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity // 현재 클래스를 데이터베이스의 테이블과 매핑 정의
@Table(name="member") // 테이블 이름 정의
public class MemberEntity extends BaseTime {

    //=================테이블의 필스/속성 설계=================//


    @Id  //primary key 제약조건
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 제약 조건
    private int mno; //회원번호

    @Column( columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String mid; //회원아이디

    @Column( columnDefinition = "varchar(20)", nullable = false)
    private String mpwd; //회원비밀번호

    @Column( columnDefinition = "varchar(10)", nullable = false )
    private String mname; //회원 이름

    @Column( columnDefinition = "varchar(13)", nullable = false, unique = true)
    private String mphone; //회원 전화번호


    //Entity => Dto
    public MemberDto toDto(){

        // + 빌더패턴 이용한 인스턴스 생성
        //MemberDto.builder().필드명(새로운값).build();
        return MemberDto.builder() //.build() 빌더패턴의 시작
                .mno(this.mno)
                .mid(this.mid)
                .mname(this.mname)   //빌더 패턴 이용한 인스턴스 생성
                .mphone(this.mphone
                        ).build();// .build() 빌더패턴의 끝마침
    }

}
