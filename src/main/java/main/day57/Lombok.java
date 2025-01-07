package main.day57;

public class Lombok {
    public static void main(String[] args) {

        //1. 디폴트 생성자로 객체 생성
            //@NoArgsContructor 어노테이션이 디폴트 생성자를 주입/만들어준다.
        MemberDto m1 = new MemberDto();

        //2. 모든매개변수 생성자로 객체생성
            //@AlllArgsContructor 어노테이션이 모든 매개변수 생성자를 주입
        MemberDto m2 = new MemberDto("qwe1","강호동");

        //+매개변수 1개로 구성된 생성자가 없으므로 오류
        //MemberDto m3 = new MemberDto("qwe1");

            //6. 빌더 패턴을 사용한 인스턴스를 만들었을때
            MemberDto m3 = MemberDto.builder().id("asdf1").name("유재석").build();

        //3. setter 메소드 이용
            //@Setter 어노테이션이 멤버변수의 setter 메소드를 주입/만들어준다.
        m1.setId("asdf1");

        //4. getter 메소드 이용
            //@Getter 어노테이션이 멤버변수의 getter 메소드를 주입/만들어준다.
        System.out.println(m1.getId());

        //5. toString 메소드 사용
            //@ToString 어노테션이 멤버변수의 값들을 반환하는 toString 메소드를 주입/만들어준다
        System.out.println(m1.toString());
        System.out.println(m1); //객체 참조(주소) 값 대신 멤버변수 값 호출하고 싪을때 toString()


    }
}
