package main.day54.boardservice13.model.dao;

import main.day54.boardservice13.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {

    private Connection con;

    //+싱글톤 작업
    private static BoardDao boardDao = new BoardDao();
    public static BoardDao getInstance(){return boardDao;}
    private BoardDao() {
        //====DB연동=====//
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0102",
                    "root", "1234"
            );} catch (Exception e) {e.printStackTrace();}
    }

        //1. 게시물 작성
        public boolean write (BoardDto boardDto){
            try {
                String sql = "insert into board(btitle,bcontent,bwriter,bpwd) " +
                        "value (?,?,?,?)"; //1. sql 작성
                PreparedStatement ps = con.prepareStatement(sql); //2. sql 기재

                ps.setString(1, boardDto.getBtitle());
                ps.setString(2, boardDto.getBcontent());
                ps.setString(3, boardDto.getBwriter());
                ps.setString(4, boardDto.getBpwd());

                int count = ps.executeUpdate();

                if (count == 1) {
                    return true;    // -> 업데이트 성공했으면 true
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        //2. 게시물 전체 조회
        public ArrayList<BoardDto> findAll(){
            //여러개 레코드를 Dto로 만들어서 지정할 리스트 객체 선언
            ArrayList<BoardDto> list = new ArrayList<>();

            try{

                String sql = "select * from board"; //1. sql 작성한다
                PreparedStatement ps = con.prepareStatement(sql); // 2. sql 기재한다.
                //3. sql 실행하고 결과를 조작하는 ResultSet 인터페이스로 받는다
                ResultSet rs = ps.executeQuery();

                while(rs.next()){ //다음 값이 없을때까지 값 조회
                    BoardDto boardDB = new BoardDto(
                        rs.getInt("bno"),
                        rs.getString("btitle"),
                        rs.getString("bcontent"),
                        rs.getString("bwriter"),
                        rs.getString("bdate"),
                        null     );//->패스워드는 보안상 조회시 제외

                    //6. 만든 Dto에 ArrayList에 대입
                    list.add(boardDB);
                }//조회 끝

            }catch(SQLException e){e.printStackTrace();} // 예외처리
                return list; // 조회한 값 반환
        }

        //3. 게시물 개별 조회
        public BoardDto findid(int bno){
        //구현하기 전
            try {
                String sql = "select * from board where bno=?";//(1) sql작성한다
                PreparedStatement ps = con.prepareStatement(sql);//(2) sql 기재한다
                ps.setInt(1, bno); //(3) 기재된 sql의 매개변수를 대입한다
                ResultSet rs = ps.executeQuery();//(4) 기재된 sql 실행하고 결과를 반환 받는다
                if(rs.next()){//(5) 실행결과에 따른 제어한다
                    BoardDto boardDB = new BoardDto(
                            rs.getInt("bno"),
                            rs.getString("btitle"),
                            rs.getString("bcontent"),
                            rs.getString("bwriter"),
                            rs.getString("bdate"),null);
                    return boardDB;
                }
            }
            catch(SQLException e ){e.printStackTrace();}
            return null;
        }

        //4. 게시물 수정
        public boolean update(BoardDto boardDto){
            try {
                            //let sampleBoard = {"bno" : 3 ,  "btitle" : "수정한제목22" ,  "bcontent" : "수정한내용22" }
                String sql = "update board set btitle =?, bcontent =? where bno=? ";//(1)sql작성
                PreparedStatement ps = con.prepareStatement(sql);//(2)sql기재
                ps.setString(1,boardDto.getBtitle());//(3)기재된 sql의 매개변수를 대입
                ps.setString(2,boardDto.getBcontent());
                ps.setInt(3,boardDto.getBno());
                int count = ps.executeUpdate();//(4)기재된 sql 실행하고 결과 반환
                if(count==1){//(5)실행 결과에 따른 제어
                    return true;
                }
            }
            catch(SQLException e){e.printStackTrace();}

            return false;
            }

        //5. 게시물 삭제
        public boolean delete(int bno){
            try {
                String sql = "delete from board where bno =? ";//(1)sql작성
                PreparedStatement ps = con.prepareStatement(sql);//(2)sql기재
                ps.setInt(1, bno);//(3)기재된 sql의 매개변수를 대입
                int count = ps.executeUpdate();//(4)기재된 sql 실행하고 결과 반환

                if (count == 1) {//(5)실행 결과에 따른 제어
                    return true;
                }
            }catch(SQLException e){e.printStackTrace();}
            return false;
        }

}//end class
