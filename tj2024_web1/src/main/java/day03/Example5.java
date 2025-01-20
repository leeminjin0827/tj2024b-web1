package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example5")
public class Example5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = true;					// 1. 응답할 자료 준비
		resp.setContentType("application/json");// 2. HTTP를 이용한 응답 헤더 정보 추가 , .setContentType()
		resp.getWriter().print( result ); 		// 2. HTTP를 이용한 요청에 따른 응답 자료 보내기
	} // f end
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "java";
		resp.setContentType("text/plain"); // 문자열 1개 application/json으로 타입변환 불가능.
		resp.getWriter().print( result );
	} // f end
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 30;
		resp.setContentType("application/json");
		resp.getWriter().print( result );
	} // f end
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataDto result = new DataDto("유재석",40);
		// DTO -> JSON 으로 변환
		// 1. ObjectMapper 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper(); // 1. ObjectMapper 인스턴스 생성
		String jsonResult = mapper.writeValueAsString( result ); // 2. .writeValusAsString( 변활할객체 ) : 지정한 객체를 JSON인식
		
		resp.setContentType("application/json"); // 오류 : DTO를 JSON으로 타입변환 불가능.
		resp.getWriter().print( jsonResult );
		
	} // f end
} // c end
