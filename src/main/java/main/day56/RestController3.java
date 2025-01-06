package main.day56;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day56/rest3")
public class RestController3 {

    @GetMapping("")
    public boolean getRest3(){
        return true;
    }

    @PostMapping("")
    public boolean postRest3(){
        return true;
    }

    @PutMapping("")
    public boolean putRest3(){
        return true;
    }

    @DeleteMapping("")
    public boolean deleteRest3(){
        return true;
    }

}//end class

