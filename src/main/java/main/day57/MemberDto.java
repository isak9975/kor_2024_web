package main.day57;

import lombok.*;

@NoArgsConstructor // 디폴트 생성자 코드를 주입(넣어준다)
@AllArgsConstructor // 모든 매개변수의 생성자 코드를 주입
@Getter
@Setter
@ToString
@Builder

public class MemberDto {

    private String id;
    private String name;


}
