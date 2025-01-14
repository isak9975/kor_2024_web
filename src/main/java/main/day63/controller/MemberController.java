package main.day63.controller;

import main.day63.model.dto.MemberDto;
import main.day63.model.entity.MemberEntity;
import main.day63.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired private MemberService memberService;

    @PostMapping("/member/signup")
        //*관례적으로 controller 에서는 엔티티를 사용하지 않는다.
    public boolean signup(@RequestBody MemberDto memberDto){
        return memberService.signup(memberDto);
    }

    @GetMapping("/member/infolist")
    public List<MemberDto> infolist(){
        return memberService.infolist();
    }




}
