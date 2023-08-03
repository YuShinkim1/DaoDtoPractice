package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.boardDto;

public class boardDao {
    public Connection getConnection() throws Exception {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbId = "testw8";
        String dbPw = "pass1234";

        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbId, dbPw);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public ArrayList<boardDto> getBoardListByPageNum(int pageNum) throws Exception {
        Connection conn = getConnection();
        int endRnum = pageNum * 15;   // 이해
        int startRnum = endRnum - 14;  // 이해
        ArrayList<boardDto> listBoard = new ArrayList<boardDto>();
        String sql = "SELECT *"
                    + " FROM (SELECT rownum rnum, t1.*"
                    + " FROM (SELECT * FROM board ORDER BY bno DESC) t1) t2"
                    + " WHERE t2.rnum>=? AND t2.rnum<=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, startRnum);
        pstmt.setInt(2, endRnum);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            int bno = rs.getInt("bno");
            String title = rs.getString("title");
            String content = rs.getString("content");
            String writer = rs.getString("writer");
            String writedate = rs.getString("writedate");
            boardDto dto = new boardDto(bno,title,content,writer,writedate);
            listBoard.add(dto);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return listBoard;
    }
    
    public String boardmain(int bno) throws Exception  {
    	
    		Connection conn = getConnection();
    		
    		String sql = "SELECT content FROM board WHERE bno=?";
    		
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, bno);
    		
    		ResultSet rs = pstmt.executeQuery();
    		String content="";
    		if(rs.next()) {
    			content = rs.getString("content");
    		}
    		rs.close();
    		pstmt.close();
    		conn.close();
    		return content;
    }
}