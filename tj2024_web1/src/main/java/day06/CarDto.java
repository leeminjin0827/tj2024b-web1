package day06;

public class CarDto {

	private int num;
	private String cnum;
	private int cloc;
	private String cin;
	private String cout;
	private int cmoney;
	
	public CarDto() {}
	public CarDto(int num, String cnum, int cloc, String cin, String cout, int cmoney) {
		super();
		this.num = num;
		this.cnum = cnum;
		this.cloc = cloc;
		this.cin = cin;
		this.cout = cout;
		this.cmoney = cmoney;
	}
	
	@Override
	public String toString() {
		return "carDto [num=" + num + ", cnum=" + cnum + ", cloc=" + cloc + ", cin=" + cin + ", cout=" + cout
				+ ", cmoney=" + cmoney + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public int getCloc() {
		return cloc;
	}
	public void setCloc(int cloc) {
		this.cloc = cloc;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getCout() {
		return cout;
	}
	public void setCout(String cout) {
		this.cout = cout;
	}
	public int getCmoney() {
		return cmoney;
	}
	public void setCmoney(int cmoney) {
		this.cmoney = cmoney;
	}
	
} // c end
