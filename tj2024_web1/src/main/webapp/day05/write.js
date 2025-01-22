// 게시물 등록
const boardWrite = () => {
	// HTML로 부터 input dom 객체 가져오기
	let titleInput = document.querySelector('.titleInput');
	let contentInpit = document.querySelector('.contentInput');
	let writerInput = document.querySelector('.writerInput');
	let passwordInput = document.querySelector('.passwordInput');
	// 입력받은값 가져오기
	let title = titleInput.value;
	let content = contentInpit.value;
	let writer = writerInput.value;
	let password = passwordInput.value;
	// 객체화
	let dataObj = { btitle : title , bcontent : content ,
					bwriter : writer , bpwd : password
	}
	// fetch 통신
	let option = {
		method : 'POST' , // METHOD 방법 선택
		headers : { 'Content-Type' : 'application/json' }, // HTTP 요청 HEADER CONTENT-TYPE 
		body : JSON.stringify( dataObj ) // 본문에 보낼 자료를 문자열 타입으로 변환
	} // o end
	fetch( `/tj2024_web1/day05/board` , option )
		.then( r => r.json() )
		.then( data => {
			// 결과에 따른 화면 구현
			if( data == true ) { alert('게시물 등록 성공'); boardFindAll(); }
			else{ alert('게시물 등록 실패 ㅋㅋ'); }
		}) // then2 end
		.catch( e => { console.log( e ); } )
	
} // f end