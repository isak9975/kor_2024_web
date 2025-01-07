package main.day57task.Model.Dto;


import lombok.*;

@AllArgsConstructor // 모든 매개변수 생성자 주입
@NoArgsConstructor // 디폴트 생성자 주입
@Getter             // 각 멤버변수의 Getter 메소드 주입
@Setter             // 각 멤버변수의 Setter 메소드 주입
@ToString           // 참조(주소)값 대신 멤버변수 호출 메소드 주입
@Builder            // 생성자 대신 인스턴스(객체) 만드는 빌더 패턴 주입

public class StudentDto {

//    <SQL>
//    sno int auto_increment,           //학생 번호
//    sname varchar(30) not null,       //학생 이름
//    skor int,                         //국어 점수
//    smath int,                        //영어 점수
//    seng int,                         //수학 점수
//    primary key (sno));

    private int sno;
    private String sname;
    private int skor;
    private int smath;
    private int seng;


}
