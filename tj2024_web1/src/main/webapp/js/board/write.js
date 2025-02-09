
// [*] 썸머노트 실행
$(document).ready(function() {
  $('#summernote').summernote();
});

// [1] 글쓰기 요청 메소드
const onWrite = ( ) => {
	
	// 첨부파일 있다 = from 전송 vs 첨부파일 없다 = form 또는 JSON
	
	// 1. 입력받은 값들을 가져오기 위해서 DOM 객체 호출
	const cnoselect = document.querySelector('.cnoselect'); console.log( cnoselect );
	const titleinput = document.querySelector('.titleinput'); console.log( titleinput );
	const contentinput = document.querySelector('.contentinput'); console.log( contentinput );
	
	// 2. DOM 객체 에서의 입력받은 (value속성)값 호출
	const cno = cnoselect.value; console.log( cno );
	const btitle = titleinput.value; console.log( btitle );
	const bcontent = contentinput.value; console.log( bcontent );
		// 왜 3개의 변수를 선언했고 왜 변수명 btitle 변경했을까? api명세서에서 약속
	
	// 3. 값들을 묶어주는 객체( json ) 만들기 , json의 속성명은 rest명세서 맞게 정의
	let obj = { cno : cno , btitle : btitle , bcontent : bcontent }
		console.log( obj );
	// 4. fetch option
	const option = { 
		method : 'POST' ,
		headers : { 'Content-Type' : 'application/json'} ,
		body : JSON.stringify( obj ) // JSON형식(모양)의 문자열 타입으로 변환
	}
	fetch( `/tj2024_web1/board` , option )
		.then( response => response.json())
		.then( data => {
			console.log( data );
			if( data == true ){
				alert('글쓰기 성공');
				location.href=`board.jsp?cno${ cno }`
			}else{
				alert('글쓰기 실패');
			}
		})
		.catch( error => { console.log( error ); } )
} // f end