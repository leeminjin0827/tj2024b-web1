package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/waiting")
public class WaitingController extends HttpServlet{
	
	// 대기번호등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. URL 상의 쿼리스트링 매개변수를 가져온다.		연락처 , 인원수
		String phone = req.getParameter("phone");
		int number = Integer.parseInt(req.getParameter("number") ); // 문자열을 int로 변환
		// 2. 매개변수를 DAO에게 전달하고 결과를 받기
		boolean result = WaitingDao.getInstance().write( phone , number );
		System.out.println( result );
		
	} // f end
	
	// 대기번호삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. URL 상의 쿼드스트링 매개변수를 가져온다. 대기식별번호PK
		int mno = Integer.parseInt(req.getParameter("mno") ); // 문자열을 int로 변환
		// 2. 매개변수를 DAO에게 전달하고 결과 받기
		boolean result = WaitingDao.getInstance().delete( mno );
		System.out.println( result );
	} // f end
	
	
	
} // c end
