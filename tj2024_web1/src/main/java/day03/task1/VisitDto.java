package day03.task1;

public class VisitDto {
	
	// 1.
	private String content;
	private int age;
	// 2.
	public VisitDto() {}
	public VisitDto(String content, int age) {
		super();
		this.content = content;
		this.age = age;
	}
	// 3.
	@Override
	public String toString() {
		return "VisitDto [content=" + content + ", age=" + age + "]";
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
