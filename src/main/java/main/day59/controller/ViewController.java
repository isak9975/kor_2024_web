package main.day59.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
        //+ 탬플릿 파일들을 (View) 반환하는 메소드들을 모아둔 클래스

    //1. 메인페이지 반환하는 get 매핑 함수
    @GetMapping("/index")
    public String index(){return "/day59/index.html";}

    //2. 회원가입 페이지 반환 하는 get 매핑 함수
    @GetMapping("/signup")
    public String signup(){return "/day59/signup.html";}


    //3. 로그인 페이지 반환 하는 get 매핑 함수
    @GetMapping("/login")
    public String login(){return "/day59/login.html";}

}
