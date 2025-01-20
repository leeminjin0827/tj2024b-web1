package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WaitingDao {
	private Connection conn;
	
	// + 싱글톤
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0120",
					"root" , "1234");
		}catch( Exception e ) { System.out.println( e ); }
	}
	public static WaitingDao getinstance () { return instance; }
	// - 싱글톤
	
	// 1. 대기번호 등록 SQL
	public boolean write(WaitingDto waitingDto ) {
		try {
			String sql = "insert into waiting2(phone,number)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPhone() );
			ps.setInt(2, waitingDto.getNumber() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	// 2. 대기번호 조회 SQL
	public ArrayList<WaitingDto> findAll() {
		ArrayList<WaitingDto> list = new ArrayList<WaitingDto>();
		try {
			String sql = "select * from waiting2";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				WaitingDto waitingDto = new WaitingDto();
				waitingDto.setId( rs.getInt("id") );
				waitingDto.setPhone( rs.getString("phone") );
				waitingDto.setNumber( rs.getInt("number") );
				list.add(waitingDto);
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return list;
	} // f end
	
	// 3. 대기번호 수정 SQL
	public boolean update( WaitingDto waitingDto) {
		try {
			String sql = "update waiting2 "
					+ " set phone = ? , number = ? "
					+ " where id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPhone() );
			ps.setInt(2, waitingDto.getNumber() );
			ps.setInt(3, waitingDto.getId() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	// 4. 대기번호 삭제 SQL
	public boolean delete( int id ) {
		try {
			String sql = "delete from waiting2 where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }	
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	
	
} // c end
