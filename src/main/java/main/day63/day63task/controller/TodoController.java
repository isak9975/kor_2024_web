package main.day63.day63task.controller;

import main.day63.day63task.model.dto.TodoDto;
import main.day63.day63task.model.entity.TodoEntity;
import main.day63.day63task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    //할일 등록
    public boolean todowrite(TodoDto todoDto){
        return todoService.todowrite(todoDto);
    }

    //할일 전체 조회
    public List<TodoDto> todoprint(){
        return todoService.todoprint();
    }

    //할일 상태 수정
    public boolean todoupdate(TodoDto todoDto){
        return todoService.todoupdate(todoDto);
    }

    //할일 삭제
    public boolean tododelete(int tno){
        return todoService.tododelete(tno);
    }

}
