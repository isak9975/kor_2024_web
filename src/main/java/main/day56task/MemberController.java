package main.day56task;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day56task/member1")
public class MemberController {

    //회원가입
    @PostMapping("/day56task/sign")
    public String postsign(MemberDto memberDto){
        System.out.println("MemberController.postsign");
        System.out.println("memberDto = " + memberDto);

        return memberDto.getMid() + "님 회원가입 완료";
    }

    //로그인
    @PostMapping("/day56task/login")
    public String postlogin(MemberDto memberDto){
        System.out.println("MemberController.postlogin");
        System.out.println("memberDto = " + memberDto);
        return memberDto.getMid() + "님 로그인 완료";
    }

    //회원수정
    @PutMapping("/day56task/update")
    public boolean putupdate(MemberDto memberDto){
        System.out.println("MemberController.putupdate");
        return true;
    }

    //내정보 보기
    @GetMapping("/day56task/findall")
    public String[] getfindall(){
        System.out.println("MemberController.getfindall");



        String[] result = new String[
                ];

        return result;
    }

    //회원탈퇴
    @DeleteMapping("/day56task/delete")
    public boolean delete(){
        System.out.println("MemberController.delete");
        return true;
    }
}
