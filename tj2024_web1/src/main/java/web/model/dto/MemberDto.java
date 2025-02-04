package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString

public class MemberDto {
	
	private int mno;		// 회원번호
	private String mid;		// 아이디 
	private String mpwd;	// 비밀번호
	private String mname;	// 이름
	private String mphone;	// 연락처 
	private String mdate;	// 가입일 
	private String mimg;	// 프로필
	private String mpoint;	// 자바 내부적으로 사용
	
} // c end
