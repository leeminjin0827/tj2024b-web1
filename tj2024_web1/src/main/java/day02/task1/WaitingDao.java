package day02.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	
	private Connection conn;

	// + 싱글톤
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0116",
					"root" , "1234");
		}catch( Exception e ) { System.out.println( e ); }
	}
	public static WaitingDao getInstance () { return instance; }
	// - 싱글톤
	
	// 대기번호등록
	public boolean write( String phone , int number ) {
		try {
			String sql  = "insert into waiting(phone,number)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setInt(2, number);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	
	// 대기번호삭제
	public boolean delete( int mno ) {
		try {
			String sql = "delete from waiting where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	
} // c end
