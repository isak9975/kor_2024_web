package main.day63.model.dto;


import lombok.*;
import main.day63.model.entity.MemberEntity;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    //+멤버변수
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;

    private String cdate; // 회원 가입 날짜/시간    //JPA Auditing 기능활용
    private String update; // 회원 정보 수정 날짜/시간

    //Dto => entity ( 롬복 제공 하지 않음 )
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                //(방법1) 빌더패턴  - 순서 상관없음 - 생성자 보다 발달
                //인스턴스를 생성자를 이용하여 만들었다면 규칙이 존재한다. 유연한 인스턴스를 생성하는 방법
                //인스턴스를 생설할때 생성자 보다 유연한 생성 방법 제시
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .mname(this.mname)
                .mphone(this.mphone)
                .build();
            //(방법2)생성자 - 순서 바뀌면 안됌
            //return new MeberEntity(this.mno, this.mid, this.mpwd, this.mname, this.mphone)
    }



}//end class
