package day06;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day06/user")
public class User extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		CarDto carDto = mapper.readValue( req.getReader(), CarDto.class);
		
		if(carDto.getCloc()<1 || carDto.getCloc()>20) {
			resp.setContentType("application/json");
			resp.getWriter().print( false );
		}else {
		boolean result = CarDao.getInstance().write( carDto );
		resp.setContentType("application/json");
		resp.getWriter().print( result );
		}
		

	} // f end
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cnum = req.getParameter("cnum");
		// DAO 처리
		CarDto carDto = CarDao.getInstance().findEach( cnum );
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( carDto );
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
		System.out.println("get");
	} // f end
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		CarDto carDto = mapper.readValue(req.getReader(), CarDto.class);
		boolean result = CarDao.getInstance().carout(carDto);
		resp.setContentType("application/json");
		resp.getWriter().print( result );
	} // f end
	
	
	
} // c end
