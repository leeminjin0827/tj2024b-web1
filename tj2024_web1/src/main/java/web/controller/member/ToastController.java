package web.controller.member;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/toastsocket")
public class ToastController {
	// 접속 성공한 세션 저장(list)
	private static List< Session > onlist = new Vector<>();
	
	@OnOpen // 서버소켓에 접속 했을때
	public void onOpen( Session session ) {
		System.out.println("클라이언트가 서버에 접속 성공");
		
		onlist.add(session); // list 안에 접속 성공한 세션 정보 저장
		System.out.println( onlist );
	} // f end
	
	@OnMessage // 클라이언트 가 보낸 메시지를 서버가 정상적으로 받았을떄. (자동) 실행
	public void onMessage( Session session , String massage) {
		// 접속한 모든 유저들에게 보내기위해 반복문으로 순회
		for( int index = 0; index <= onlist.size() -1; index++ ) {
			// 접속된 명단의 index번째 세션(접속정보) 가져오기
			Session client = onlist.get(index);
			try {
				client.getBasicRemote().sendText(massage);
			}catch( Exception e ) { System.out.println( e ); }
			
		} // for end
	}
	
	@OnClose // 서버 연결이 닫혔을때
	public void onClose( Session session ) {
		onlist.remove( session ); // 접속이 닫힌 클라이언트 소켓을 list 에서 제거
	} // f end
} // c end
