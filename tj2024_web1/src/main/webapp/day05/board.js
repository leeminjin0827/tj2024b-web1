
// 게시물 전체 조회 // 켜질때 , 등록/수정/삭제
const boardFindAll = ( ) => {
	// 어디에
	let tbody = document.querySelector('tbody');
	// 무엇을 왓
	let html = '';
		// METHOD 설정
		const option = { method : 'GET' }
		// fetch
		fetch('/tj2024_web1/day05/board')
			.then( r => r.json() )
			.then( data => {
				data.forEach( obj => {
					html += `<tr>
								<td> ${ obj.bno } </td>
								<td>
									<a href="view.jsp?bno=${ obj.bno }">
									${ obj.btitle } </td>
								<td> ${ obj.bwriter } </td>
								<td> ${ obj.bview } </td>
								<td> ${ obj.bdate } </td>
							</tr>`
				}) // for end
				// 출력
				tbody.innerHTML = html;
			})// then2 end
			.catch( e => { console.log( e ); } )
} // f end
boardFindAll();
