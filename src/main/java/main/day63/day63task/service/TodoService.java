package main.day63.day63task.service;

import main.day63.day63task.model.dto.TodoDto;
import main.day63.day63task.model.entity.TodoEntity;
import main.day63.day63task.model.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired private TodoRepository todoRepository;

    public boolean todowrite(TodoDto todoDto){
        TodoEntity todoEntity = todoDto.toEntity();
        //받아온 정보(Dto)를 전달하기 위해 엔티티로 변환함

        TodoEntity saveEntity = todoRepository.save(todoEntity);
        //변환한 정보(엔티티)를 리포지토리의 save 를 사용하여 저장 및 결과를 저장.

        if(saveEntity.getTno()>0){
            return true;
        }
        return false;

    }

    public List<TodoDto> todoprint(){
        List<TodoEntity> todoEntityList = todoRepository.findAll();
        //저장되어있는 모든 정보(엔티티)를 조회

        List<TodoDto> todoDtoList = new ArrayList<>();
        //찾아온 객체를 전달할 때 쓸 Dto 리스트 선언

        for(int index=0;index <=todoEntityList.size()-1;index++){
            //나중에 forEach 사용
            TodoEntity todoEntity = todoEntityList.get(index);
            //리스트를 돌면서 정보(엔티티)들을 가져온다
            todoDtoList.add(todoEntity.toDto());
            //찾아온 정보(엔티티)들을 전달을 위해 Dto형태로 저장한다.
        }
        return todoDtoList;
    }

    public boolean todoupdate(TodoDto todoDto){

        TodoEntity findtodoEntity = todoRepository.findById(todoDto.getTno()).get();

        findtodoEntity.setTcontent(todoDto.getTcontent());
        findtodoEntity.setTstatus(todoDto.getTstatus());

        return true;
    }

    public boolean tododelete(int tno){
        todoRepository.deleteById(tno);
        return true;
    }

}
