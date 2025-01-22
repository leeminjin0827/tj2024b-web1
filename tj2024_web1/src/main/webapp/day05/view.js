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
			
		})
		.catch( error => { console.log( error ); } )
		
	// 4. fetch 응답에 따른 화면 출력
	
} // f end
boardfindEach(); // JS가 열릴 때 최초 실행