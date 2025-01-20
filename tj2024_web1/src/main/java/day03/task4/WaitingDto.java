package day03.task4;

public class WaitingDto {
	
	private int id;
	private String phone;
	private int number;
	
	public WaitingDto() {}
	public WaitingDto(int id, String phone, int number) {
		super();
		this.id = id;
		this.phone = phone;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "WaitingDto [id=" + id + ", phone=" + phone + ", number=" + number + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
} // c end
