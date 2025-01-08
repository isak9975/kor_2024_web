package main.day59.model.dao;

import main.day59.model.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class MemberDao {

    private Connection con;
    private String DBURL = "jdbc:mysql://localhost:3306/mydb0109";
    private String DBUSER = "root";
    private String DBPWD = "1234";


    //[0] DB연동
    public MemberDao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBURL,DBUSER,DBPWD);
//            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0109",
//                    "root","1234" );
        }
        catch(Exception e){e.printStackTrace();}
    }//end dao

    //[1] 회원가입 SQL 처리
    public boolean signup(MemberDto memberDto){
        try{
            String sql = "insert into member (mid,mpwd,mname,mphone) values (?,?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ps.setString(3, memberDto.getMname());
            ps.setString(4, memberDto.getMphone());

            int count = ps.executeUpdate();

            if(count == 1){
                return true;
            }
        } catch (SQLException e) {e.printStackTrace();}

        return false;
    }


    //[2] 로그인 SQL 처리
    public boolean login(String mid, String mpwd){
        try{
            String sql="select * from member where mid=? and mpwd=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, mid);
            ps.setString(2, mpwd);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }
        }
        catch(SQLException e){e.printStackTrace();}
        return false;
    }


}
