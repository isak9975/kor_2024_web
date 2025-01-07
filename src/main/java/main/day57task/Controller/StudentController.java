package main.day57task.Controller;

import main.day57task.Model.Dao.StudentDao;
import main.day57task.Model.Dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/day57task/student")
@RestController //+객체(빈) 생성해서 메모리(Spring 컨테이너) 등록한다
                    // 이 클래스의 객체(빈)는 너가(Spring) 관리해줘 : IOC
public class StudentController {

                        //너(Spring)가 만든 클래스의 빈(객체/인스턴스) 를 주세요
                        @Autowired private StudentDao studentDao; // DI 의존성 주입



    //1. 학생 등록 기능
    @PostMapping
    public boolean write(){

        return false;
    }

    //2. 학생 정보 보기 기능
    @GetMapping
    public ArrayList<StudentDto> findAll(){

        ArrayList<StudentDto> list = new ArrayList<>();

        return list;
    }

    //3. 학생 수정 기능
    @PutMapping
    public boolean update(StudentDto studentDto){

        return true;
    }
    //4. 학생 삭제 기능
    @DeleteMapping
    public boolean delete(int sno){

        return true;
    }

}
