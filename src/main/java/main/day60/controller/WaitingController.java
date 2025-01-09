package main.day60.controller;

import main.day60.model.WaitingDto;
import main.day60.service.WaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WaitingController {

        @Autowired WaitingService waitingService;

    @PostMapping("/register.do")
    public boolean register(@RequestBody WaitingDto waitingDto){
        boolean result = waitingService.register(waitingDto);
        return result;
    }

    @GetMapping("/total.do")
    public ArrayList<WaitingDto> total(){
        ArrayList<WaitingDto> result = waitingService.total();
        return result;
    }

}
