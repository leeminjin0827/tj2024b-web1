package day03.task2;

public class WaitingDto {
	//
	private String phone;
	private int number;
	//
	public WaitingDto() {}
	public WaitingDto(String phone, int number) {
		super();
		this.phone = phone;
		this.number = number;
	}
	//
	@Override
	public String toString() {
		return "WaitingDto [phone=" + phone + ", number=" + number + "]";
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
