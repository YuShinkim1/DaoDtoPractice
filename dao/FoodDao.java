package dao;

import java.sql.*;
import java.util.*;

import dto.FoodDto;

public class FoodDao {
	private Connection conn;
	
	public FoodDao() {
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

	public ArrayList<FoodDto> getFoodList(ArrayList<FoodDto> foodList){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT food_no, food_name, food_price, food_img, food_category FROM cafe_food";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String foodNo = rs.getString("food_no");
				String foodName = rs.getString("food_name");
				int foodPrice = rs.getInt("food_price");
				String foodImg = rs.getString("food_img");
				String foodCategory = rs.getString("food_category");
				
				foodList.add(new FoodDto(foodNo, foodName, foodPrice, foodImg, foodCategory));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
			}catch(Exception e) {
				
			}
		}
		return foodList;
	}
}
