package main.day56;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day56/rest4")
public class RestController4 {

    @GetMapping("")
    //요청 : [GET] http://localhost:8080/day56/rest4?key1=유재석&key2=강호동
    public boolean getRest4(@RequestParam String key1, @RequestParam String key2){
        System.out.println("RestController4.getRest4");
        System.out.println("key1 = " + key1 + ", key2 = " + key2);
        return true;    //응답 : Content-Type : 'application/json' (@RestController(@ResponseBody))
    }//end get

    @GetMapping("/dto")
    public boolean getRest5(RestDto restDto){
        //쿼리스트링의 매개변수명과 Dto의 멤버변수명이 동일하면 자동으로 매개변수가 주입된다
        //*생성자를 꼭 필수로 만들어야 한다
        System.out.println("restDto = " + restDto);
        System.out.println("RestController4.getRest4");
        return false;
    }

    @PostMapping("")    //http://localhost:8080/day56/rest4
    public String postRest4(@RequestBody RestDto restDto){
        System.out.println("restDto = " + restDto);
        System.out.println("RestController4.postRest4");
        return "restDto 보내기 완료";
    }

//    @PostMapping
//    @PutMapping
//    @DeleteMapping


}//end class
