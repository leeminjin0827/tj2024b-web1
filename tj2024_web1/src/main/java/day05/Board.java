package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class Board extends HttpServlet{
	
	// 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP 로 부터 요청 받은 HTTP HEADER BODY 를 DTO로 변환
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader(), BoardDto.class);
		// DAO 처리
		boolean result = BoardDao.getinstance().write( boardDto );
		// DAO 결과를 HTTP HEADER BODY로 보내기
		resp.setContentType("application/json");
		resp.getWriter().print( result );
		System.out.println("post");
	} // f end
	
	// 전체조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DAO 처리
		ArrayList<BoardDto> result = BoardDao.getinstance().findAll();
		// DAO 처리 결과를 HTTP HEADER BODY로 보내기
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( result );
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
		System.out.println("get");
	} // f end
	
	// 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP로 부터 요청 받은 HTTP HEADER BODY를 DTO로 변환
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader(), BoardDto.class);
		// DAO 처리
		boolean result = BoardDao.getinstance().update( boardDto );
		// DAO 결과를 HTTP HEADER BODY로 보내기
		resp.setContentType("application/json");
		resp.getWriter().print( result );
		System.out.println("put");
	} // f end
	
	// 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿼리스트링 매개변수 가져오기
		int bno = Integer.parseInt( req.getParameter("bno") );
		// DAO 처리
		boolean result = BoardDao.getinstance().delete( bno );
		// DAO 결과를 HTTP HEADER BODY로 보내기
		resp.setContentType("application/json");
		resp.getWriter().print( result );
		System.out.println("delete");
	}
	
} // c end
