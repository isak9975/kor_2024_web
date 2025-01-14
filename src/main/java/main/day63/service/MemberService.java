package main.day63.service;

import main.day63.model.dto.MemberDto;
import main.day63.model.entity.MemberEntity;
import main.day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired private MemberRepository memberrepository;

    //1. 회원가입
    public boolean signup(MemberDto memberDto){

        //1. 저장할 DTO 를 entity로 변환한다.
        MemberEntity memberEntity = memberDto.toEntity();
        //2. 변환된 entity 를 save 한다.
        //3. save 결과 entity 변환 받는다
        MemberEntity saveEntity = memberrepository.save(memberEntity);
        //4. 회원번호(auto_increment)를 확인하여 엔티티가 잘 생성 했는지 확인
        if(saveEntity.getMno() > 0){
            return true; // 회원가입 성공
        }
        return false; // 회원가입 실패
    }



    //2. 모든 회원 목록 조회
    public List<MemberDto> infolist(){
        //1. 모든 엔티티를 조회한다.
        List<MemberEntity> entitylist = memberrepository.findAll();
        //2. 모든 엔티티를 Dto 로 변환한다.
        List<MemberDto> list = new ArrayList<>();//변환된 Dto를 저장할 리스트 선언

        for(int index = 0;index <= entitylist.size()-1;index++){
            //0부터 엔티티리시트의 마지막 인덱스까지 1씩 증가 반복
            MemberEntity entity = entitylist.get(index);
            //index번째의 엔티티 1개 반환한다.
            list.add(entity.toDto()); //index번째의 엔티티를 Dto로 변환 후 리스트 저장
        }
        return list;//모든 엔티티를 dto를 변환후 반환.
    }


}
