package main.day53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
//[1]스프링 서버를 실행하기위한 클래스
public class Appstart {
    public static void main(String[] args) {
        SpringApplication.run(Appstart.class);
    }
}

@RestController
class day53Controller{
    @PostMapping("/day53")   //HTTP [POST] http://localhost:8080/day52 주소 선언/만들기
    public String postMethod(){
        System.out.println("day53Controller.postMethod");
        return "server connect POST OK";}

    @GetMapping("/day53")   //HTTP [GET] http://localhost:8080/day52 주소 선언/만들기
    public String getMethod(){
        System.out.println("day53Controller.getMethod");
        return "server connect GET OK";
    }

    @PutMapping ("/day53")   //HTTP [PUT] http://localhost:8080/day52 주소 선언/만들기
    public String putMethod(){
        System.out.println("day53Controller.putMethod");
        return "server connect PUT OK";
    }

    @DeleteMapping("/day53")   //HTTP [DELETE] http://localhost:8080/day52 주소 선언/만들기
    public String deleteMethod(){
        System.out.println("day53Controller.deleteMethod");
        return "server connect DELETE OK";
    }
}