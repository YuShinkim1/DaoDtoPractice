package dto;

public class ownerDto {
	private int seatNo;
	private String foodName;
	private int foodPrice;
	private String orderComment;
	private int count;
	private int payTool;

	// 기본 생성자
	public ownerDto() {
	}

	// 생성자
	public ownerDto(int seatNo, String foodName, int foodPrice, String orderComment, int count, int payTool) {
		this.seatNo = seatNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.orderComment = orderComment;
		this.count = count;
		this.payTool = payTool;
	}

	// Getter와 Setter 메서드들
	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
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

	public String getOrderComment() {
		return orderComment;
	}

	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPayTool() {
		return payTool;
	}

	public void setPayTool(int payTool) {
		this.payTool = payTool;
	}

	// toString 메서드
	@Override
	public String toString() {
		return "OwnerDto{" + "seatNo=" + seatNo + ", foodName='" + foodName + '\'' + ", foodPrice=" + foodPrice
				+ ", orderComment='" + orderComment + '\'' + ", count=" + count + ", payTool=" + payTool + '}';
	}
}
