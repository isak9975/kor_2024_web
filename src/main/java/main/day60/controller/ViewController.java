package main.day60.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/index")
    public String index(){return "/day60/index.html";}

    @GetMapping("/register")
    public String register(){return "/day60/register.html";}

    @GetMapping("/total")
    public String total(){return "/day60/total.html";}

}
