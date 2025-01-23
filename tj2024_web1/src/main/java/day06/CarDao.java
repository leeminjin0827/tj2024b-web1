package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CarDao {
	private Connection conn;
	
	// + 싱글톤
	private static CarDao instance = new CarDao();
	private CarDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/car",
					"root" , "1234");
		}catch( Exception e ) { System.out.println( e ); }
	}
	public static CarDao getInstance () { return instance; }
	// - 싱글톤
	
	// 입차
	public boolean write( CarDto carDto ) {
		try {
			String sql = "insert into carr( cnum , cloc ) values( ? , ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, carDto.getCnum() );
			ps.setInt(2, carDto.getCloc() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
 		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	// 정산조회
	public CarDto findEach(String cnum) {
		try {
			String sql = "select cnum, cloc, cin, cout, cmoney from carr where cnum = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cnum);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				CarDto carDto = new CarDto();
				carDto.setCnum( rs.getString("cnum") );
				carDto.setCloc( rs.getInt("cloc") );
				carDto.setCin( rs.getString("cin") );
				carDto.setCout( rs.getString("cout") );
				carDto.setCmoney( rs.getInt("cmoney") );
				return carDto;
			}
		}catch( SQLException e ) { System.out.println( e );}
		return null;
	}
	public boolean carout(CarDto carDto) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime cout = LocalDateTime.parse(carDto.getCout(), formatter);
			String sql = "select cin from carr where cnum = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, carDto.getCnum());
	        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            String cinString = rs.getString("cin");
		            LocalDateTime cin = LocalDateTime.parse(cinString);  
		
		            Duration duration = Duration.between(cin, cout);
		            int seconds = (int) duration.getSeconds();  

		            int money = seconds * 100;

		            String updateSql = "update carr set cout = ?, cmoney = ? where cnum = ?";
		            PreparedStatement updatePs = conn.prepareStatement(updateSql);
		            updatePs.setString(1, cout.toString());  
		            updatePs.setInt(2, money);  
		            updatePs.setString(3, carDto.getCnum());  

		            int count = updatePs.executeUpdate();
		            if (count == 1) {
		                return true;  
		            }
		        }
		    } catch (SQLException e) {
		        System.out.println(e);
		    }
		    return false;  
		}
	
	// 출차
	
	// 관리자.조회
	
	
	
	
	
	
	
	
	
	
	
} // c end
