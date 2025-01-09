package main.day58;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

//@ResponseBody
@Controller //화면 사용할때
//    @RestController -> 화면 사용안할때 ex)데이터베이스

class ViewController{
//    @GetMapping
//    public String index(){return "/day58/index.html";}
//    @GetMapping("/layout") // 매핑/연결 할 Http URL 정의
//    public String index2(){return "/day58/layout/index.html";}
    @GetMapping("/student")
    public String student(){return "/day58/student/index.html";}
        //지정한 경로에 위치한 타임리프 템플릿을 렌더링 하여 HTML 로 반환, 동적파일 ---> 정적파일
        //해당 클래스에서 RestController 안됨, 해당 메소드에도 ResponseBody 사용 안됨.

    @GetMapping("/student/regist")
    public String regist(){return "/day58/student/register.html";}
    @GetMapping("/student/list")
    public String list(){return "/day58/student/list.html";}
    @GetMapping("/student/update")
    public String update(){return "/day58/student/update.html";}
    @GetMapping("/student/delete")
    public String delete(){return "/day58/student/delete.html";}

}//end class
