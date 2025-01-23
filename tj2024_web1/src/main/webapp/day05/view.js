
// 게시글 개별 조회
const boardfindEach = ( ) => {
	// 1. 현재 URL의 쿼리스트링 매개변수 가져온다. *day25참고*
		// * 내가 board.jsp 에서 클릭한 게시물 번호가 존재하면 쿼리스트링
	let bno = new URL( location.href ).searchParams.get('bno');
	// 2. fetch 옵션
	const option = { method : 'GET' }
	// 3. fetch 통신
	fetch( `/tj2024_web1/day05/board/view?bno=${ bno }` , option )
		.then( response => response.json() )
		.then( data => {
			document.querySelector('.bdbox').innerHTML = `${ data.bdate }`
			document.querySelector('.bwbox').innerHTML = `${ data.bwriter }`
			document.querySelector('.bvbox').innerHTML = `${ data.bview }`
			document.querySelector('.btbox').innerHTML = `${ data.btitle }`
			document.querySelector('.bcbox').innerHTML = `${ data.bcontent }`
			// - 다른  함수에서 게시물 정보를 이용하기 위해 게시물정보를 전역변수로 이동
			boardInfo = data;
		})
		.catch( error => { console.log( error ); } )
		
	// 4. fetch 응답에 따른 화면 출력
	
} // f end
boardfindEach(); // JS가 열릴 때 최초 실행

// 게시물 정보 객체 전역변수
let boardInfo = null;

// 게시글 삭제
const boardDelete = ( ) => {
	console.log( boardInfo );
	// 1. 어떤 게시물 삭제 할껀지? 쿼리스트링에 존재한다.
		// JS에서 현재 페이지 쿼리스트링 매개변수 가져오기
		// new URL( location.href ) : 현재 URL 정보 가져오기
		// searchParams : 쿼리스트링 매개변수들
		// .get('매개변수명') : 매개변수들에서 특정한 매개변수 값 반환
	let bno = new URL( location.href ).searchParams.get('bno');
	// 삭제할 게시물의 비밀번호 검증
	let passwordCheck = prompt( '게시물 비밀번호 : ');
	
		// - 만약에 현재 게시물의 비밀번호가 일치하지 않으면
	if( boardInfo.bpwd != passwordCheck ){
		alert('비밀번호가 일치하지 않습니다...'); // 안내후
		return; // 함수 강제 종료. , 아래 코드(fetch) 는 실행되지 않는다.
	} // if end
	// 검증이 맞다면 fetch 이용한 삭제 요청
	const option = { method: 'DELETE' }
	fetch( `/tj2024_web1/day05/board?bno=${ bno }` , option )
		.then( response => response.json() )
		.then( data => {
			// 그에 따른 화면 제어
			if( data == true ){
				alert('삭제 성공'); 
				location.href="board.jsp";
			}else{ alert(`삭제 실패`); }
		}) // then2 end
		.catch( error => { console.log( error ); } )
	
	// 그에 따른 화면 제어
	
} // f end

// JS에서 현재 페이지 쿼리스트링 매개변수 가져오기
// new URL( location.href ) : 현재 URL 가져오기
// .searchParams : 쿼리스트링 매개변수들
// .get('매개변수명') :매개변수들에서 특정한 매개변수 값 반환

// 수정 페이지 이동
const boardUpdate = ( ) => {
	
	// 1. 비밀번호 검증
	let passwordCheck = prompt('게시물 비밀번호 : ')
	if( boardInfo.bpwd != passwordCheck ) {
		alert('비밀번호가 일치하지 않습니다.')
		return;
	}
	// 2. 검증이 일치 하다면 수정 페이지로 이동
		// - location.href"경로"	: 페이지 이동 함수.
	location.href = `update.jsp?bno=${ boardInfo.bno }`
	
} // f end



