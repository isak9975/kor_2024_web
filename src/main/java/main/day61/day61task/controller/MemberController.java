package main.day61.day61task.controller;

import main.day61.day61task.model.entity.MemberEntity;
import main.day61.day61task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired static MemberService memberService;
    //스프링 컨테이너(메모리)에 등록된 빈(객체)을 주입한다.

    @PostMapping("/signup")
    public boolean signup(@RequestParam String id, @RequestParam String pwd){
        boolean result = memberService.signup(id,pwd);
        return result;
    }

    @GetMapping("/findAll")
    public List<MemberEntity> findAll(){
        List<MemberEntity> list = memberService.findAll();
        return list;
    }
}
