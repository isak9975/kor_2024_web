package main.day60.service;

import main.day60.model.WaitingDao;
import main.day60.model.WaitingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WaitingService {

        @Autowired
        WaitingDao waitingDao;

    public boolean register(WaitingDto waitingDto){
        boolean result = waitingDao.register(waitingDto);
        return result;
    }

    public ArrayList<WaitingDto> total(){
        return waitingDao.total();
    }
}
