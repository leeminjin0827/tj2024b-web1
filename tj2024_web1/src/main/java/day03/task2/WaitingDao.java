package day03.task2;

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
					"jdbc:mysql://localhost:3306/mydb0120",
					"root" , "1234" );
		}catch( Exception e ) { System.out.println( e ); }
	}
	public static WaitingDao getinstance () { return instance; }
	// - 싱글톤
	
	// 1. 대기번호 등록 SQL
	public boolean write( WaitingDto waitingDto ) {
		try {
			String sql = "insert into waiting(phone,number)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1 , waitingDto.getPhone() );
			ps.setInt(2, waitingDto.getNumber() );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	// 2. 대기번호 삭제 SQL
	public boolean delete( int son ) {
		try {
			String sql = "delete from waiting where son = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, son);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
} // c end
