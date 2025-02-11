package web.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
import web.model.dto.PageDto;

@WebServlet("/board")
public class BoardController extends HttpServlet{

	// 게시물 쓰기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardController dopost ok");
		
		// [1] 글쓰기 write 메소드
		// HTTP 요쳥의 header body 자료(json)를 DTO로 받기
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		// 세션 호출
		HttpSession session = req.getSession();
		// 세선에 저장된 mno 꺼내기 , .getAttribute("속성명"); , 모든 세션 객체내 속성은 Object 타입이다.
		Object object = session.getAttribute("loginMno");
		if( object != null ) {
			// Object 타입 --> int/Integer 타입으로 변환
			int loginMno = (Integer)object;
			// boardDto 에 로그인된 회원번호 담아주기 , 게시물작성자 == 로그인된 회원
			boardDto.setMno( loginMno );
		}
		// 읽어론 자료를 dao 에게 전달 후 결과 받기
		boolean result = BoardDao.getInstance().write(boardDto);
		// HTTP 로 부터 response
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	} // f end
	
	// 게시물 전체 출력 ( 02/07 +추가 : 카테고리별 )
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardController doget ok");
		// [1] 요청 매개변수 , cno 카테고리 번호 가져오기. page 번호 가져오기
		int cno = Integer.parseInt( req.getParameter("cno") );
		int page = Integer.parseInt( req.getParameter("page") );
		
			// * 페이징 처리에 필요한 자료를 준비
			// 1. 페이지당 출력할 게심루 수
			int display = 5; // 페이지 1개당 게시물 5개 출력할 예정
			// 2. 페이지당 조회할 게시물의 시작 번호 , (현재페이지-1) * 페이지당게시물수
			int startRow = (page-1) * display;
				// 게시물이 10개 존재 한다고 가정 : 0번 1번 2번 3번 4번 5번 6번 7번 8번 9번
				// 1페이지에 시작번호 : 0번 , 2페이지 시작번호 : 4번
			// 3. 특정 카테고리 게시물의 전체 페이지 수 구하기
			int totalSize = BoardDao.getInstance().getTotalSize( cno );
			// 4. 전체 페이지 
			int totalPage = 0;
			if( totalSize % display == 0 ) {
				// 전체 게시물 수 나누기 페이지당 게시물 수 했을때 나머지가 없으면
				totalPage = totalSize / display;
			}else {
				totalPage = totalSize / display +1 ; // 몫 +1
			}
			// 5. 페이지당 버튼수
			int btnSize = 5;
			// 6. 시작버튼 번호 구하기
			int startBtn = ( (page-1) / btnSize ) * btnSize+1;
			// 7. 끝버튼 번호 구하기
			int endBtn = startBtn + ( btnSize - 1);
			// * 만약에 끝번호가 전체 페이지수 보다 커지면 안되므로 끝번호가 전체페이지수 보다 커지면 전체 페이지수 로 고정
			if( endBtn > totalPage ) endBtn = totalPage;
			
		// [2] DAO에게 전체 게시물 요청 하고 결과 받기 , cno 카테고리 번호 dao 에게 전달
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll( cno , startRow , display );
		
			// 8. PageDto 객체 만들기
			PageDto pageDto = new PageDto();
			pageDto.setTotalcount( totalSize ); // 조회된 전체 게시물수
			pageDto.setPage( page ); // 전체 페이지
			pageDto.setTotalpage( totalPage ); // 전체 페이지수
			pageDto.setStartbtn( startBtn ); // 페이징 버튼 시작 번호
			pageDto.setEndbtn( endBtn ); // // 페이징 버튼 끝 번호
			pageDto.setData( result );
			
		// [3] 받은 전체 게시물을 JSON 형식의 문자열로 변환하기
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( pageDto ); // 9. pageDto 를 json 으로 변환
		// [4] http response
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	} // f end
	
	// 게시물 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardController doput ok");
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader(), BoardDto.class);
		boolean result = BoardDao.getInstance().update( boardDto );
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
	// 게시물 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardController dodelete ok");
		// [1] HTTP queryString 매개변수를 가져오기 , URL?bno=1 , req.getParameter("매개변수명") : 반환타입 문자열 이므로 타입변환 필요할 수 있다.
			// Integer.parseInt( "문자열" ) : 문자열 타입 --> 정수 타입 변환 함수.
		int bno = Integer.parseInt( req.getParameter("bno") );
		// [2] Dao 에게 삭제할 번호를 전달하고 결과 받기
		boolean result = BoardDao.getInstance().delete( bno );
		// [3] 결과를 HTTP의 response 로 응답하기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
} // c end
