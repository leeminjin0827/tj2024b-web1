package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 서블릿X
public class Example2 {
	public static void main(String[] args) {
		
		// [2] 파일의 자료를 자바 로 가져오기 (입력)
			// - FileInputStream in = new FileInputStream("파일경로");
			// - Example1 클래스에서 저장한 파일 로 작성
			// - 예외처리
		try {
			// (1) 파일입력스트림 객체 생성
			FileInputStream in = new FileInputStream("c:/hi/test1.txt");
			// (2) 바이트 배열 선언 , 임의의 크기 10(영문10글자 - 영1글자당 1바이트 , 한글 1글자당 3바이트 )
			byte[] bytes = new byte[10];
			// (3) 파일내 자료를 바이트열로 읽어오기
			in.read( bytes );
			// (4) 바이트배열을 문자열로 변환
			String str = new String( bytes );
			System.out.println( str );
			System.out.println( "파일 불러오기 성공" );
		}catch( IOException e ) { System.out.println( e ); }
		
		// [3] 파일 클래스
			// (1) 지정한 경로의 파일을 자바 객체와 연결하기.
		File file = new File("c:/hi/test1.txt");
		System.out.println( file.isFile() ); // (2) 파일 존재 여부 반환 메소드
		System.out.println( file.getName() ); // (3) 파일 이름 반환 메소드
		System.out.println( file.exists() ); // (4) 경로 존재 여부 반환 메소드
		System.out.println( file.length() ); // (5) 파일 (바이트)용량 반환 메소드
		System.out.println( file.delete() ); // (6) 파일 삭제 함수.
		System.out.println( file.getPath() );
		File file2 = new File("c:/java2");
		if( !file2.exists() ) { // 만일 java2 폴더가 존재하지 않으면
			file2.mkdir(); // 지정한 경로의 폴더 생성 함수.
		} // if end
		
		System.out.println( file.isFile() );
	} // m end
} // c end
