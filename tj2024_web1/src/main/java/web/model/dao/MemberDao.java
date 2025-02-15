package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;

// @Getter // 클래스내 모든 멤버변수에 getter 적용.
@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE ) // 클래스내 디폴트생성자를 private 적용
public class MemberDao extends Dao {
	
	// 
	// + 싱글톤
		// [1] 멤버변수의 static 인스턴스를 만든다.
		// [2] 디폴트 생성자를 private 한다.
		// [3] static 인스턴스를 반환하는 메소드 만든다.
	@Getter // 지정된 멤버변수에 getter 적용
	private static MemberDao instance = new MemberDao();
	
	// @NoArgsConstructor( access = lombok.AccessLevel.PRIVATE )
	// private MemberDao() {}
	
	// @Getter
	// public static MemberDao getInstance () { return instance; }
	
	// [1] 회원가입 SQL 처리 메소드 
	public int signup( MemberDto memberDto ) {
		try {
			// [1] SQL 작성한다.
			String sql ="insert into member( mid , mpwd , mname , mphone , mimg ) values( ? , ? , ? , ? , ? )";
			// [2] DB와 연동된 곳에 SQL 기재한다. 		
			PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
			ps.setString( 1 , memberDto.getMid() );
			ps.setString( 2 , memberDto.getMpwd() );
			ps.setString( 3 , memberDto.getMname() );
			ps.setString( 4 , memberDto.getMphone() );
			ps.setString( 5 , memberDto.getMimg() );
			// [3] 기재된 SQL를 실행하고 결과를 받는다.	
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( count == 1 ) { 
				ResultSet rs = ps.getGeneratedKeys();
				if( rs.next() ) {
					int mno = rs.getInt(1);
					return mno; // 회원가입 성공 후 등록한 회원번호 반환
				}
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return 0; // 실패시 0반환
	} // f end
	
	// [2]. 로그인 SQL 처리 메소드
	// { "mid" : "아아아" , "mpwd" : "dsasadsa" }
	public int login( MemberDto memberDto ) {
		// int : SQL로 조회된 회원번호를 반환하기 위해서
		try {
			// [1] SQL 작성한다.
			String sql = "select mno from member where mid = ? and mpwd = ? ";
			// [2] DB와 연동된 곳에 SQL 기재한다.
			PreparedStatement ps =  conn.prepareStatement(sql);
			// [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setString( 1 , memberDto.getMid() );
			ps.setString( 2 , memberDto.getMpwd() );
			// [3] 기재된 SQL 실행하고 결과를 받는다.
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( rs.next() ) {
				int mno = rs.getInt("mno");
				return mno;
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return 0;
	} // f end
	
	// [3]. 내정보 보기 SQL 처리 메소드 
	public MemberDto myInfo( int loginMno ) {
		try {
			String sql ="select * from member where mno = ? "; // [1] SQL 작성한다.
			PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
			ps.setInt(  1 , loginMno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
			ResultSet rs = ps.executeQuery(); // [3] 기재된 SQL 실행하고 결과를 받는다.
			if( rs.next() ) { // [4] 결과에 따른 처리 및 반환를 한다.
				MemberDto memberDto = new MemberDto();
				memberDto.setMno( rs.getInt("mno") );
				memberDto.setMid( rs.getString("mid") );
				memberDto.setMname( rs.getString("mname" ) );
				memberDto.setMphone( rs.getString("mphone") );
				memberDto.setMdate( rs.getString("mdate") );
				memberDto.setMimg( rs.getString("mimg") );
				return memberDto; // 조회된 회원정보를 반환한다.
			}
		}catch(SQLException e ) { System.out.println(e);}
		return null; // 조회된 회원정보가 없을때. null 반환한다
	} // f end
	
// [4]. 회원탈퇴 SQL 처리 메소드 
	public boolean delete( int loginMno ) {
		try {
			String sql = "delete from member where mno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , loginMno );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end
	
	// [5] 회원수정  SQL 처리 메소드
	// { "mpwd" : "아아아" , "mname" : "호랑이" , "mphone" : "010-8888-4444" }
	public boolean update( MemberDto memberDto ) {
		try {
			// [1] SQL 작성한다.
			String sql = "update member set mpwd = ? , mname = ? , mphone = ? where mno = ? ";
			// [2] DB와 연동된 곳(conn)에 SQL 기재한다.
			PreparedStatement ps = conn.prepareStatement( sql );
			// [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setString( 1 , memberDto.getMpwd() );
			ps.setString( 2 , memberDto.getMname() );
			ps.setString( 3 , memberDto.getMphone() );
			ps.setInt( 4 , memberDto.getMno() );
			// [3] 기재된 SQL 실행하고 결과를 받는다.
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( count == 1 ) { return true; } // 수정 성공 했을때.
		}catch (SQLException e) {		System.out.println( e ); }
		return false; // 수정 실패 했을때.
	} // f end
	
	// [6] 포인트 로그 내역 전체 조회 SQL 처리 메소드
	public ArrayList<PointDto> allInfo ( int loginMno ) {
		ArrayList<PointDto> list = new ArrayList<PointDto>();
		try {
			String sql = "select * from point where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				PointDto pointDto = new PointDto();
				pointDto.setPno( rs.getInt("pno") );
				pointDto.setPdetail( rs.getString("pdetail") );
				pointDto.setPpoint( rs.getInt("ppoint") );
				pointDto.setPdate( rs.getString("pdate") );
				pointDto.setMno( rs.getInt("mno") );
				list.add(pointDto);
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return list;
	} // f end
	
	// [7] 현재 남은 포인트 조회 SQL 처리 메소드
	public int myPoint( int loginMno ) {
		try {
			String sql = "select sum(ppoint) as mpoint from point where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) { return rs.getInt("mpoint"); }
		}catch( SQLException e ) { System.out.println( e ); }
		return -1;
	} // f end
	
	// [8] 
	public boolean setPoint( PointDto pointDto ) {
		try {
			// SQL 작성
			String sql = "insert into pointlog( pocomment , pocount , mno ) values( ? , ? , ? )";
			// DB와 연동된 곳에 SQL 기재
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pointDto.getPdetail() );
			ps.setInt(2,  pointDto.getPpoint() );
			ps.setInt(3, pointDto.getMno() );
			// SQL 실행하고 결과받기
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	}
} // c end
