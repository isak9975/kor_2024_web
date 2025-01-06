package main.day56;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestController2 {

    @GetMapping("/day56/rest2")
    public String[] getRest2(){
        return new String[] {"안녕 클라이언트","나는 GET REST1 이야"};
    }//end Get

    @PostMapping("/day56/rest2")
    public String[] postRest2(){
        return new String[] {"안녕 클라이언트","나는 Post REST1 이야"};
    }//end Post

    @PutMapping("/day56/rest2")
    public String[] putRest2(){
        return new String[] {"안녕 클라이언트","나는 Put REST1 이야"};
    }//end Put

    @DeleteMapping("/day56/rest2")
    public String[] deleteRest2(){
        return new String[] {"안녕 클라이언트","나는 Delete REST1 이야"};
    }//end Delete

}//end Class
