
// [ 수정 하기 전 정보 조회] 게시글 개별 조회 
const boardfindEach = ( ) => {
	let bno = new URL( location.href ).searchParams.get('bno');
	const option = { method : 'GET' }
	fetch( `/tj2024_web1/day05/board/view?bno=${ bno }` , option )
		.then( response => response.json() )
		.then( data => {
			document.querySelector('.newT').value = `${ data.btitle }`
			document.querySelector('.newC').value = `${ data.bcontent }`
		})
		.catch( error => { console.log( error ); } )
} // f end
boardfindEach();

// 수정 처리
const boardUpdate = ( ) => {
	// 수정할 게시물번호
	let bno = new URL( location.href ).searchParams.get('bno');
	// input DOM 객체 가져오기
	let newT = document.querySelector('.newT');
	let newC = document.querySelector('.newC');
	// input value 값 가져오기
	let btitle = newT.value;
	let bcontent = newC.value;
	// 객체화
	let dataObj = { bno : bno , btitle : btitle , bcontent : bcontent }
	// METHOD 처리 , BODY
	const option = {
		method : 'PUT' ,
		headers : {'Content-Type' : 'application/json' } ,
		body : JSON.stringify( dataObj )
	} // o end
	// fetch
	fetch( `/tj2024_web1/day05/board` , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ) {
				alert('수정완료');
				location.href=`view.jsp?bno=${ bno }`
			}
			else{ alert('수정실패'); }
		}) // then2 end
		.catch( error => { console.log( error ); } )
} // f end


// 마크업 주요 속성
// 1. innerHTML : 시작마크업과 끝마크업 사이에 <마크업> 여기 </마크업> HTML문자열 대입/호출
	// -> div , span , table 등등 , 불가능 : <input/> <img/>
// 2. value		: 마크업의 입력 속성값 <마크업 value="" /> 대입/호출
	// -> input , select , textarea , 불가능 : 레이아웃 div , span , table 등등