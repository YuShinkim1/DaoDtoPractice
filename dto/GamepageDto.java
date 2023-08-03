package dto;

public class GamepageDto {
	String foodNo;
	String foodName;
	int foodPrice;
	String foodImg;
	String foodCategory;
	
	public GamepageDto (String foodNo, String foodName, int foodPrice, String foodImg, String foodCategory) {
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImg = foodImg;
		this.foodCategory = foodCategory;
	}

	public String getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(String foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodImg() {
		return foodImg;
	}

	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	
}
