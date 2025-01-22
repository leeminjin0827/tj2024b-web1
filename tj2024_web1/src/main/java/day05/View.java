package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board/view")
public class View extends HttpServlet{

	// 개별 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bno = Integer.parseInt( req.getParameter("bno") );
		// DAO 처리
		BoardDto boardDto = BoardDao.getinstance().findEach( bno );
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( boardDto );
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
		System.out.println("get");
	} // f end
	
} // c end
