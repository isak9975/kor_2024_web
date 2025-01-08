package main.day59.service;

import main.day59.model.dao.MemberDao;
import main.day59.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service        // 스프링 컨테이너(메모리)에 빈(인스턴스) 주입
public class MemberService {

        //스프링 컨테이너(메모리)에 존재하는 빈(인스턴스) 호출
        @Autowired MemberDao memberDao;

//[1} 회원가입 서비스
public boolean signup(MemberDto memberDto){
        boolean result = memberDao.signup(memberDto);
        return result;
}

//[2] 로그인 서비스
public boolean login(String mid, String mpwd){
        boolean result = memberDao.login(mid,mpwd);
        return result;

}

}
