

// [1] 로그인 정보 요청 함수
const getLoginInfo = ( ) => {
	
	// 1. 
	const option = { method : 'GET' }
	// 2.
	
	let loginmenu = document.querySelector('.loginmenu'); // 로그인 메뉴를 출력할 구역 가져오기
	
	let html = ''; // (2) hmtl 변수 선언
	
	fetch( `/tj2024_web1/member/info` , option )
	.then( response => response.json() )
	.then( data => {
		console.log( data ); // 코드 변경 후 서버가 자동 새실행이 되면 세션 초기화.
		if( data == null ){ console.log('비로그인상태');
			// (3) 각 상태에 따라 로그인 메뉴 구성
			html += `<li class="nav-item"> <a class="nav-link" href="/tj2024_web1/member/login.jsp">로그인</a> </li>
					<li class="nav-item"> <a class="nav-link" href="/tj2024_web1/member/signup.jsp">회원가입</a> </li>`
		}
		else{ console.log('로그인상태');
			// (3) 각 상태에 따라 로그인 메뉴 구성
			html += `<li class="nav-item">
						<a class="nav-link" href="#"> <img class="header_profile" src="/tj2024_web1/upload/${ data.mimg }" /> ${ data.mid } 님 </a>
					</li>
					<li class="nav-item"> <a class="nav-link" href="/tj2024_web1/member/info.jsp">마이페이지</a> </li>
					<li class="nav-item"> <a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a> </li>`
		}
		// (4) 구성한 메뉴들을 innerHTML 한다.
		loginmenu.innerHTML = html;
	})
	.catch( error => { console.log( error ); } )
} // f end
getLoginInfo(); // JS가 열렸을때 최초 1번 실행

// [2] 로그아웃 요청 함수
const onLogOut = ( ) => {
	
	const option = { method : 'DELETE' }
	fetch( `/tj2024_web1/member/login` , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ){ 
				alert('로그아웃합니다.');
				location.href="/tj2024_web1/member/login.jsp";
			}
		})
		.catch( error => { console.log( error ); } )
} // f end