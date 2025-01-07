package main.day57task.Service;

import main.day57task.Model.Dao.StudentDao;
import main.day57task.Model.Dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service//+객체(빈) 생성해서 메모리(Spring 컨테이너) 등록한다
            // 이 클래스의 객체(빈)는 너가(Spring) 관리해줘 : IOC
public class StudentService {

    @Autowired private StudentDao studentDao;

    //1. 학생 정보 쓰기
    public boolean write(StudentDto studentDto){
        boolean result = studentDao.write(studentDto);
        return result;
    }

    //2. 학생 정보 호출
    public ArrayList<StudentDto> findAll(){
        ArrayList<StudentDto> list = studentDao.findAll();
        return list;
    }

    //3. 학생 정보 수정
    public boolean update(StudentDto studentDto){
        boolean result = studentDao.update(studentDto);
        return result;
    }

    //4. 학생 정보 삭제
    public boolean delete(int sno){
        boolean result = studentDao.delete(sno);
        return result;
    }


}
