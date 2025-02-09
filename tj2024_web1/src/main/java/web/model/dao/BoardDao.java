package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE ) // 클래스내 디폴트 생성자를 private 적용
public class BoardDao extends Dao{
	
	// @NoArgsConstructor( access = lombok.AccessLevel.PRIVATE )
	// private BoardDao()
	@Getter
	// public static BoardDao getInstance () { return instance; }
	private static BoardDao instance = new BoardDao();
	
	// [1] 글쓰기 write SQL 메소드
	public boolean write( BoardDto boardDto ) {
		try {
			String sql = "insert into board( btitle , bcontent, mno , cno ) values( ? , ? , ? , ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle() );
			ps.setString(2, boardDto.getBcontent() );
			ps.setInt(3, boardDto.getMno() );
			ps.setInt(4, boardDto.getCno() );
			int count = ps.executeUpdate();
			if( count == 1) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	// [2] 게시물 전체 조회 SQL 메소드
	public ArrayList<BoardDto> findAll ( int cno ) {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			// 게시물 전체조회
			// String sql = "select * from board";
			// 게시물 테이블의 모슨 속성 과 회원 테이블의 mid 속성도 조회 , innner join : 다른 테이블과 같이 조회할때 , 조인 조건 주로 : pk - fk
			// select* from 테이블A inner join 테이블B on 테이블A.PK필드명 = 테이블B.FK필드명;
			// 정렬 : order by 필드명 desc=내림차순 , asc=오름차순
			// + 카테고리별 출력 , 조건추가
			String sql = " select * from board b inner join member m on b.mno = m.mno "
					+ " where cno = ? "
					+ "order by b.bno desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , cno );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt( "bno" ) );
				boardDto.setBtitle( rs.getString( "btitle" ) );
				boardDto.setBcontent( rs.getString( "bcontent" ) );
				boardDto.setBview( rs.getInt( "bview" ) );
				boardDto.setBdate( rs.getString( "bdate" ) );
				boardDto.setCno( rs.getInt( "cno" ) );
				boardDto.setMno( rs.getInt( "mno" ) );
				boardDto.setMid( rs.getString( "mid") ); // 회원테이블과 조인 한 결과 회원아이디 도 조회 가능하다.
				list.add(boardDto);
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return list;
	} // f end
	
	// [3] 게시물 수정 SQL 메소드
	public boolean update ( BoardDto boardDto ) {
		try {
			String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle() );
			ps.setString(2, boardDto.getBcontent() );
			ps.setInt(3, boardDto.getBno() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	// [4] 게시물 삭제 SQL 메소드
	public boolean delete ( int bno ) {
		try {
			String sql = "delete from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end
	
	// [5] 게시물 개별 조회 SQL 메소드
	public BoardDto findByBno( int bno ) {
		try {
			// (1) 특성 게시물 테이블의 게시물 1개 조회
			// String sql = "select * from board where bno = ?";
			// (2) 게시물 테이블과 회원 테이블 교집합 구해서 회원아이디로 조회 가능
			// String sql = "select * from board b inner join member b on b.mno = m.mno";
			// (3) 게시물 테이블과 회원 테이블 과 카테고리 테이블 교집합 구해서 회원아이디 와 카테고리명 조회 가능
			String sql = "select * from board b "
					+ " inner join member m on b.mno = m.mno "
					+ " inner join category c on b.cno = c.cno "
					+ " where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt( "bno") );
				boardDto.setBtitle( rs.getString( "btitle") );
				boardDto.setBcontent( rs.getString( "bcontent") );
				boardDto.setBview( rs.getInt( "bview" ) );
				boardDto.setBdate( rs.getString( "bdate" ) );
				boardDto.setCno( rs.getInt( "cno" ) );
				boardDto.setMno( rs.getInt( "mno" ) );
				boardDto.setMid( rs.getString( "mid" ) ); // 회원 테이블과 조인 한 결과 회원아이디
				boardDto.setCname( rs.getString( "cname" ) ); // 카테고리테이블과 조인한 결과 카테고리명
				return boardDto;
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return null;
	} // f end
	
} // c end
