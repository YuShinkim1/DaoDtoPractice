package dao;

import java.sql.*;
import java.util.*;
import dto.ownerDto;

public class ownerDao {
    private Connection conn;

    public ownerDao() {
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            String uid = "admin1";
            String pwd = "1234";
            String url = "jdbc:oracle:thin:@localhost:1521:XE?useUnicode=true&characterEncoding=UTF-8";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, uid, pwd); // 데이터베이스 연결 수행
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ownerDto> getOwnerList(ArrayList<ownerDto> ownerList) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT o.food_name, o.food_price, o.food_count, o.food_comment, o.seat_no, o.pay_tool "
                + "FROM cafe_food f, cafe_food_order_list o " + "WHERE f.food_name = o.food_name "
                + "ORDER BY o.seat_no ASC";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int seatNo = rs.getInt("seat_no");
                String foodName = rs.getString("food_name");
                int foodPrice = rs.getInt("food_price");
                String orderComment = rs.getString("food_comment");
                int count = rs.getInt("food_count");
                int payTool = rs.getInt("pay_tool");

                ownerList.add(new ownerDto(seatNo, foodName, foodPrice, orderComment, count, payTool));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ownerList;
    }
}
