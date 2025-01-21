// 1. 대기 명단 등록 함수
const visitWrite = ( ) => {
	// HTML 으로 부터 input dom 객체 가져오기
	let pInput = document.querySelector('.pInput');
	let nInput = document.querySelector('.nInput');
	// 입력받은 값 가져오기
	let phone = pInput.value;
	let number = nInput.value;
	// 객체화
	let dataObj = { 'phone' : phone , 'number' : number };
	// fetch 통신
	let option = {
		method : `POST`, // HTTP METHOD 방법 선택
		headers : { 'Content-Type' : 'application/json' }, // HTTP 요청 
		body : JSON.stringify( dataObj ) // 본문에 보낼 자료를 문자열로 변환
	} // o end
	fetch( `/tj2024_web1/day03/waiting2` , option )
		.then( r => r.json() ) // 응답받은 body를 json 타입으로 변환
		.then( data => { // 변환된 body
			// 결과에 따른 화면 구현
			if( data == true ) { alert(`등록성공`); visitFineAll(); }
			else{ alert(`등록실패`); }
		})
		.catch( e => { console.log( e ); } )
} // f end

// 2. 대기 명단 전체 출력 함수
const visitFineAll = ( ) => {
	// 어디에
	let tbody = document.querySelector('tbody')
	// 무엇을
	let html = '';
		// HTTP METHOD 방법 선택
		const option = { method : `GET` }
		// fetch
		fetch( `/tj2024_web1/day03/waiting2`)
			.then( r => r.json() )
			.then( data => {
				data.forEach( tb => {
					html += `<tr>
								<td> ${ tb.id } </td>
								<td> ${ tb.phone } </td>
								<td> ${ tb.number } </td>
								<td>
								<button onclick="visitUpdate( ${ tb.id },${ tb.phone } )"> 수정 </button>
								<button onclick="visitDelete( ${ tb.id } )"> 삭제 </button>
								</td>
							</tr>`
				}) // for end
				tbody.innerHTML = html;
			}) // then2 end
} // f end
visitFineAll(); // 최초 선언

// 3. 특정 대기 명단 삭제 함수
const visitDelete = ( id ) => {
	// 삭제할 식별자 id
	// HTTP METHOD 방법 선택
	const option = { method : `DELETE` }
	// fetch
	fetch( `/tj2024_web1/day03/waiting2?id=${ id }` , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ) { alert(`명단삭제성공 이제 오지마`); visitFineAll(); }
			else{ alert(`명단삭제실패ㅈㅈ`); }
		})
		.catch( e => { console.log( e ); } )
} // f end

// 4. 특정 대기 명단 (인원수)수정 함수
const visitUpdate = ( id , phone ) => {
	// 수정할 식별자 id
	// fetch 이용한 서블릿에게 HTTP update Method 처리 요청
	let newNumber = prompt(`수정할 인원수 : `);
	// 객체화
	let dataObj = { id : id , phone : phone , number : newNumber }
	// HTTP METHOD 방법 선택
	const option = {
		method : `PUT`,
		headers : { 'Content-Type' : 'application/json' },
		body : JSON.stringify( dataObj )
	} // o end
	fetch( `/tj2024_web1/day03/waiting2` , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ) { alert(`수정완료`); visitFineAll(); }
			else{ alert(`수정실패`); }
		})
		.catch( e => { console.log( e ); } )
} // f end


