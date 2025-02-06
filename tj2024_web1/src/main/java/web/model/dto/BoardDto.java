package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class BoardDto {

	// 게시물 번호
	private int bno;
	// 게시물 제목
	private String btitle;
	// 게시물 내용
	private String bcontent;
	// 게시물 작성일
	private String bdate;
	// 게시물 조회수
	private int bview;
	// 게시물 작성자
	private int mno;
	// 카테고리 번호
	private int cno;
	// + HTML에 출력할때 작성자의 회원번호가 아닌 작성자 ID 출력
	private String mid;
	// + HTML에 출력할때 카테고리의 번호가 아닌 카테고리 명을 출력
	private String cname;
	
} // f end
