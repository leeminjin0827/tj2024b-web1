package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet{

	// DTO 역할
	// private ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
	private int mno = 0;
	// 대기명단등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" waiting POST OK ");
		//1. [HTTP 요청의 header body 자료(JSON)를 HashMap으로 받는다.]
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> map = mapper.readValue(req.getReader(), HashMap.class);
		mno += 1;
		map.put( "대기번호", mno );
		HttpSession session = req.getSession();
		session.setAttribute( "대기번호" , mno );
		session.setAttribute( "인원수" , map.get("인원수") );
		session.setAttribute( "전화번호" , map.get("전화번호") );
		list.add(map);
		resp.setContentType("application/json");
		resp.getWriter().print( " 대기번호 : " + mno );
		System.out.println(list);
	} // f end
	
	// 대기명단전체출럭
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" waiting GET OK ");
		System.out.println(list);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString( list );
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end
	
	// 특정대기명단삭제 // for로 찾기
	@Override 
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" waiting DELETE OK ");
		int mno = Integer.parseInt( req.getParameter("mno") );
		HttpSession session = req.getSession();
		Object object = session.getAttribute("대기번호");
		resp.setContentType("application/json");
		resp.getWriter().print( true );
		
	} // f end
	
	// 특정대기명단(인원수)수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" waiting PUT OK ");
		
	} // f end
	
	
} // c end

//1. [HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
//2. [ 데이터 유효성검사 ] 
//3. [ DAO 에게 데이터 전달 하고 응답 받기 ]
//4. [ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다. ]
//5. [ HTTP 응답의 header body 로 application/json 으로 응답/반환하기 ]
