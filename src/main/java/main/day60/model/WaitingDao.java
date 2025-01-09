package main.day60.model;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;


@Component
public class WaitingDao {

    Connection con;

    public WaitingDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0113", "root", "1234");
        }
        catch(Exception e){e.printStackTrace();}
    }//end dao

    public boolean register(WaitingDto waitingDto){
        try{
            String sql = "insert into waiting (number,count) value (?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,waitingDto.getNumber());
            ps.setInt(2,waitingDto.getCount());

            int count = ps.executeUpdate();

            if(count==1){
                return true;
            }

        }
        catch(SQLException e){e.printStackTrace();}

        return false;
    }// end f

    public ArrayList<WaitingDto> total(){
        ArrayList<WaitingDto> list = new ArrayList<>();

        try{
            String sql = "select * from waiting ";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                WaitingDto waitingDto = new WaitingDto(
                        rs.getInt("no"),
                        rs.getString("number"),
                        rs.getInt("count")
                );
                list.add(waitingDto);
            }

        }
        catch(SQLException e){e.printStackTrace();}

        return list;

    }



}// end class
