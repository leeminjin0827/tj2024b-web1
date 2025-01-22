// 게시글 수정
const boardUpdate = ( ) => {
	let bno = new URL( location.href ).searchParams.get('bno');
	console.log( bno );
	// 수정할 식별자
	// fetch 이용한 서블릿에게 HTTP update METHOD 처리 요청
	let newTitle = document.querySelector('.newT').value;
	let newContent = document.querySelector('.newC').value;
	// 객체화
	let dataObj = { bno : bno , btitle : newTitle , bcontent : newContent }
	console.log("보낼데이터",dataObj)
	// fetch 이용한 서블릿에게 METHOD 처리 요청 , BODY
	const option = {
		method : 'PUT',
		headers : { 'Content-Type' : 'application/json' } , 
		body : JSON.stringify( dataObj )
	} // o end
	//fetch
	fetch(`/tj2024_web1/day05/board` , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ) { alert('수정 성공'); boardFindAll(); }
			else{ alert('수정 실패 ㅋㅋ'); }
		}) // then2 end
		.catch( error => { console.log( error ); } )
} // c end