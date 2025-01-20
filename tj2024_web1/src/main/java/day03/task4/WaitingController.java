package day03.task4;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting2")
public class WaitingController extends HttpServlet{
	
	// 1.대기번호등록 // { "phone" : "010-1111-2222" , "number" : 11 }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP로 부터 요청 받은 HTTP HEADER BODY 를 DTO로 변환
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue( req.getReader(), WaitingDto.class );
		// DAO 처리
		boolean result = WaitingDao.getinstance().write(waitingDto);
		// DAO 결과를 HTTP HEADER BODY로 보내기
		resp.setContentType("application/json");
		resp.getWriter().print( result );
		
	} // f end
	
	// 2. 대기번호조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DAO 처리
		ArrayList<WaitingDto> result = WaitingDao.getinstance().findAll();
		// DAO 결과를 HTTP HEADER BODY로 보내기
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( result );
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
	} // f end
	
	// 3. 대기번호수정 // { "id" : 1 , "phone" : "010-2211-2222" , "number" : 11 }
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP로 부터 요청 받은 HTTP HEADER BODY 를 DTO로 변환
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue( req.getReader(), WaitingDto.class);
		// DAO 처리
		boolean result = WaitingDao.getinstance().update( waitingDto );
		// DAO 결과를 HTTP HEADER BODY로 보내기
		resp.setContentType("application/json");
		resp.getWriter().print( result );
	} // f end
	
	// 4. 대기번호삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP로 부터 요청 받은 HTTP HEADER BODY 를 DTO로 변환
		int id = Integer.parseInt( req.getParameter("id") );
		// DAO 처리
		boolean result = WaitingDao.getinstance().delete( id );
		// DAO 결과를 HTTP HEADER BODY로 보내기
		resp.setContentType("application/json");
		resp.getWriter().print( result );
	} // f end
	
} // c end
