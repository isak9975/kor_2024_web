package main.day63.day63task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ViewController {

    @GetMapping("/todoprint")
    public String todoprint(){
        return "/todoprint.html";
    }

    @PostMapping("/todowrite")
    public String todowrite(){
        return "/todowrite.html";
    }

    @PutMapping("/todoupdate")
    public String todoupdate(){
        return "/todoupdate.html";
    }


    @DeleteMapping("/tododelete")
    public String tododdelete(){
        return "/tododelete.html";
    }

}
