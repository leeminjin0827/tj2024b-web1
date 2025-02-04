package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.PointDto;

@WebServlet("/member/point")
public class pointController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("point get!");
		
		// 	* 동일한 HTTP 메소드 안에서 서로 다른 서비스 구분 하는 방법
			// [1] '포인트 로그 내역 전체 조회' 와 '현재 남은 포인트 조회' 를 쿼리스트링 이용하여 서비스 구분
			// type : 조회 서비스 방법 식별 , 1 : 포인트 로그 내역 전체 조회 2 : 현재 남은 포인트 조회
			// '포인트 로그 내역 전체 조회' : localhost:8080/point?type=all
			// '포인트 로그 내역 전체 조회' : localhost:8080/point?type=current
//		String type = req.getParameter("type");
//		// [2] 타입 정보에 따라 구분
//		if( type.equals("all") ) {
//			// 전체 조회 dao 호출
//		}else if( type.equals("current") ) {
//			// 남은 포인트 조회 dao 호출
//		}else { }
		
		// [1] 서비스 타입 정보를 쿼리스트링 으로 가져오기
		Object result = null;
			// 현재 로그인된 회원의 번호 : 세션객체 내 존재, 속성명 : loginMno
		HttpSession session = req.getSession(); // 세션 가져오기
		// 세션객체내 지정한 속성값 가져오기
		Object object = session.getAttribute("loginMno");
		// 만약에 세션객체내 지정한 속성값이 존재하면 로그인회원번호를 타입변환한다.
		if( object != null ) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().allInfo( loginMno );
		} // if end
		// 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( result );
		// HTTP 응답의 header body로 application/json 으로 반환
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
		
	} // f end
	
	
} // c end
