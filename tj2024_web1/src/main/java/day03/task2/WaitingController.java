package day03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet{

	// 대기번호 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper();
		// 변환
		WaitingDto waitingDto = mapper.readValue( req.getReader() , WaitingDto.class );
		// DAO 처리
		boolean result = WaitingDao.getinstance().write(waitingDto);
		System.out.println(result);
	} // f end
	
	// 대기번호 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 매개변수를 파싱 하기 위한 코드
		int son = Integer.parseInt( req.getParameter("son") );
		System.out.println( "son : " + son );
		// DAO 처리
		boolean result = WaitingDao.getinstance().delete(son);
		System.out.println( result );
	} // f end
	
} // c end
