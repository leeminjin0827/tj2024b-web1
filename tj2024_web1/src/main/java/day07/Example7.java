package day07;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// [1] 톰캣 안에 있는 객체 호출 및 (첫 HTTP 요청)
		HttpSession httpSession = req.getSession();
		System.out.println( httpSession ); // HTTP 요청한 클라이언트 브라우저의 세션 객체 주소
		// 1요청시 : org.apache.catalina.session.StandardSessionFacade@2294ba42
		// 2요청시 : org.apache.catalina.session.StandardSessionFacade@2294ba42
		
		// [2] 세션 객체의 주요 메소드
		System.out.println( httpSession.getAttributeNames() );		// 세션 객체내 모든 속성 반환 함수.
		// 1요청시 : java.util.Collections$3@2c534060
		// 2요청시 : java.util.Collections$3@1408f4fd
		
		System.out.println( httpSession.getCreationTime() );		// 세션 객체가 만들어진 시간
		// 1요청시 : 1737874666283
		// 2요청시 : 1737874666283
		
		System.out.println( httpSession.getId() );					// 세션 객체의 아이디/식별자
		// 1요청시 : BF0CDF440F2E0B0581F189AFCC4202A3
		// 2요청시 : BF0CDF440F2E0B0581F189AFCC4202A3
		
		System.out.println( httpSession.getLastAccessedTime() );	// 마지막으로 세션 객체 사용시간
		// 1요청시 : 1737874666283
		// 2요청시 : 1737874666284
		
		System.out.println( httpSession.isNew() );					// 새로 만들어진 세션 인지 여부 반환
		// 1요청시 : true
		// 2요청시 : false
		
		// [3] 세션 객체의 속성명 과 값 저장
		httpSession.setAttribute( "세션속성1", "유재석" );
		
		// [4] 세션 객체의 지정한 속성명의 값 호출
		Object object = httpSession.getAttribute( "세션속성1" );
		System.out.println( (String)object );
		
		// [5] 세션 객체의 지정한 속성 제거
		httpSession.removeAttribute("세션속성1");
		
	} // f end
} // c end
