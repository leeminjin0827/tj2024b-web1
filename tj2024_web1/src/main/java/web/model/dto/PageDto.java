package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬북 준비
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class PageDto { // 페이징처리된 데이터들의 이동객체
	
	private int totalcount;	// 전체 자료 개수 ( 검색결과 조회시사용 )
	private int page;		// 현재 페이지
	private int totalpage;	// 전체 페이지수
	private int startbtn;	// 버튼 시작번호
	private int endbtn;		// 버튼 끝번호
	// * Object 타입으로 사용한 이유
	// - Object 타입은 자바의 최상위 클래스 이므로 모든 타입들의 자료들을 저장할 수 있다.
	// - data 에는 List<boardDto> , List<replyDto> 등등 여러 타입들을 하나의 타입에서 저장한다.
	private Object data;	// 페이징된 자료
	
} // c end
