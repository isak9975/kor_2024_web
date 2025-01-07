package main.day57task.Model.Dao;

import main.day57task.Model.Dto.StudentDto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component//+객체(빈) 생성해서 메모리(Spring 컨테이너) 등록한다
                // 이 클래스의 객체(빈)는 너가(Spring) 관리해줘 : IOC
public class StudentDao {

    private Connection con;

    public StudentDao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0107",
                                                    "root","1234" );
        }
        catch(Exception e){e.printStackTrace();}
    }//end Dao

    public boolean write(StudentDto studentDto){
        String sql = "insert into student(sname,skor,seng,smath) value (?,?,?,?)";
        try{
            PreparedStatement ps =  con.prepareStatement(sql);

            ps.setString(1,studentDto.getSname());
            ps.setInt(2,studentDto.getSkor());
            ps.setInt(3,studentDto.getSeng());
            ps.setInt(4,studentDto.getSmath());

            int count =  ps.executeUpdate();

            if(count==1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<StudentDto> findAll(){
        String sql = "select * from student";

        ArrayList<StudentDto> list = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                StudentDto studentDto = new StudentDto(
                        rs.getInt("sno"),
                        rs.getString("sname"),
                        rs.getInt("skor"),
                        rs.getInt("seng"),
                        rs.getInt("smath")
                );

                list.add(studentDto);
            }


        }
        catch(SQLException e){e.printStackTrace();}


        return list;
    }

    public boolean update(StudentDto studentDto){
        String sql = "update student set sname=?,skor=?,seng=?,smath=? where sno = ? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, studentDto.getSname());
            ps.setInt(2,studentDto.getSkor());
            ps.setInt(3,studentDto.getSeng());
            ps.setInt(4,studentDto.getSmath());
            ps.setInt(5,studentDto.getSno());

            int count = ps.executeUpdate();

            if(count==1){
                return true;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return false;
    }

    public boolean delete(int sno){
        String sql = "delete from student where sno =?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,sno);

            int count = ps.executeUpdate();

            if(count == 1){
                return true;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return false;
    }


}//end class
