package main.day65.service;

import jakarta.transaction.Transactional;
import main.day65.model.dto.BoardDto;
import main.day65.model.entity.BoardEntity;
import main.day65.model.entity.MemberEntity;
import main.day65.model.repository.BoardRepository;
import main.day65.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;

    @Autowired private BoardRepository boardRepository;
    //[1] ㄴ가 쓴글 전체 조회
    public List<BoardDto> myBoardList(int mno){
        //1. mno 의 회원 엔티티를 찾는다
            // 자바의 Optional 클래스 : null 값을 포함 할 수 있는 객체
            // 특징 : 1. Null 값을 안전하게 유무 판단
            // 주요메소드 :
                // 1. isPresent() : 값 존재 여부 판단 함수
                // 2. get() : Optional 객체가 갖고 있는 값 반환 함수
            // 사용처 : JPA 의 findById() 함수의 반환 타입
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(mno);

        if(optionalMemberEntity.isPresent()){//만약에 findById 함수로 찾은 mno 의 엔티티가 존재하면
            MemberEntity memberEntity = optionalMemberEntity.get(); // Optional 객체에서 엔티티를 꺼낸다.
            // 2. 찾은 엔티티에서 양방향으로 설정된 게시물 조회
            List<BoardEntity> boardEntityList = memberEntity.getBoardEntityArrayList();
            /* 첫번째 방법
            List<BoardDto> list = new ArrayList<>();
            // 3. 모든 게시물 엔티티를 Dto로 변환
            for(int index =0; index <= boardEntityList.size()-1;index++){
                BoardEntity boardEntity = boardEntityList.get(index);// index 번째 엔티티 호출
                //엔티티 Dto로 변환
                BoardDto boardDto = boardEntity.toDto();
                //dto를 리스트에 저장
                list.add(boardDto);
            }
            */

            /*    //방법2, forEach( 반복변수 -> {실행문;}) , -> java방법 / =>js방법
            List<BoardDto> list = new ArrayList<>();
            boardEntityList.forEach(boardEntity -> {list.add(boardEntity.toDto());});
             */

            // 방법3  .stream().map(타입::실행함수명).collect(Collectors.반환할컬렉션타입)
            List<BoardDto> list = boardEntityList.stream()
                    .map(BoardEntity::toDto)
                    .collect(Collectors.toList()); //반환타입
            return list;
        }//end if
        return null;
    }//end f

        @Transactional // 함수안에서 insert, update, delete 쿼리문들을 트렌젝션으로 사용.
        //트렌젝션이란? 여러 작업들을 하나의 작업 단위로 묶어, 하나라도 작업을 실패하면 모두 실패/ ㅅ롤백
        //[2] 게시물 작성, 양방향 관계일때
        public boolean myBoardWirte(BoardDto boardDto){
        //+ 현제 로그인된 회원이 게시물을 작성한다는 가정
            //1. 현재 로그인된 회원번호를 세션에서 조회한다.
        int loginMno = 1; //(예시) 1번 회원이 로그인된 상태일때 가정
            //1-2 현제 로그인된 회원번호의 회원엔티티 조희
            Optional<MemberEntity> optionalMember = memberRepository.findById(loginMno);
                if(optionalMember.isPresent()==false){
                    return false; //조회된 엔티티가 없으면 실패로 함수 변화 // 비로그인상태
                }
            MemberEntity memberEntity = optionalMember.get(); // 현재 로그인된 회원엔티티 꺼내기

            //2. 게시물 엔티티 생성한다 Dto ==> 엔티티 변환 //입력받은걸 엔티티를 처음 생성할때는 영속성(DB테이블과 매핑)없다.
            BoardEntity boardEntity = boardDto.toEntity(); //=> 받아온거 dto => entity
            //3. 게시물 엔티티에 회원정보 넣어주기
            boardEntity.setMemberEntity(/*현재 로그인된 회원엔티티*/memberEntity);
            //4. 게시물 엔티티 저장하기.
            BoardEntity saveEntity = boardRepository.save(boardEntity); // 영속성 연결(중요)
            //5. .save(엔티티) : 엔티티의 저장을 성공하면 pk번호를 확인하여 0보다 크면 성공/아니면 실패 //엔티티 저장을 성공한 엔티티 영속성 연결 /매핑
            if(saveEntity.getBno()>0){return true;}// pk번호는 1보다 크므로
            return false;
        }





}//end calss
