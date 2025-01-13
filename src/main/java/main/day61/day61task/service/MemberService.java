package main.day61.day61task.service;

import main.day61.day61task.model.entity.MemberEntity;
import main.day61.day61task.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;

    public boolean signup(String id, String pwd){

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.id = id;
        memberEntity.pwd = pwd;
        memberRepository.save(memberEntity);
        return true;
    }

    public List<MemberEntity> findAll(){
        List<MemberEntity> list = memberRepository.findAll();
        return list;
    }


}//end service
