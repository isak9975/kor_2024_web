package main.day57task.Controller;

import main.day57task.Model.Dao.StudentDao;
import main.day57task.Model.Dto.StudentDto;
import main.day57task.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController //+객체(빈) 생성해서 메모리(Spring 컨테이너) 등록한다
                    // 이 클래스의 객체(빈)는 너가(Spring) 관리해줘 : IOC
@RequestMapping("/day57task/student")
public class StudentController {

                        //너(Spring)가 만든 클래스의 빈(객체/인스턴스) 를 주세요
                        @Autowired private StudentDao studentDao; // DI 의존성 주입

                        @Autowired private StudentService studentService;


    //1. 학생 등록 기능
    @PostMapping
    public boolean write(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.write");
        System.out.println("studentDto = " + studentDto);

        boolean result = studentService.write(studentDto);
        return result;
    }

    //2. 학생 정보 보기 기능
    @GetMapping("")
    public ArrayList<StudentDto> findAll(){
        System.out.println("StudentController.findAll");
        System.out.println();

        ArrayList<StudentDto> list = studentService.findAll();
        return list;
    }

    //3. 학생 수정 기능
    @PutMapping
    public boolean update(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.update");
        System.out.println("studentDto = " + studentDto);

        boolean result = studentService.update(studentDto);
        return result;
    }
    //4. 학생 삭제 기능
    @DeleteMapping
    public boolean delete(@RequestParam int sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);

        boolean result = studentService.delete(sno);
        return result;
    }

}
