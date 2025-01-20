package main.day65.controller;

import main.day65.model.dto.BoardDto;
import main.day65.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
@Autowired private MemberService memberService;

// [1] 내가 쓴글 전체 조회
@GetMapping("/info/board/findall")
public List<BoardDto> myBoardList(@RequestParam int mno){
  return memberService.myBoardList(mno);
}

//[2] 게시물 작성
    @PostMapping("/info/board/write")
    public boolean myBoardWrite(@RequestBody BoardDto boardDto){
    return memberService.myBoardWirte(boardDto);
    }





}
