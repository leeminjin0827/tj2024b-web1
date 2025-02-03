<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/header.jsp" />

	<!-- 회원가입 폼 -->
	<div class="container col-xl-10 col-xxl-8 px-4 py-5">
	    <div class="row align-items-center g-lg-5 py-5">
	      <!-- 왼쪽 메시지 구역 -->
	      <div class="col-lg-7 text-center text-lg-start">
	        <h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3"> 더조은 로그인 </h1>
	        <p class="col-lg-10 fs-4">도망가</p>
	      </div>
	      
	      <!--  오른쪽 로그인 입력 구역 -->
	      <div class="col-md-10 mx-auto col-lg-5">
	      
	        <form class="p-4 p-md-5 border rounded-3 bg-body-tertiary">

	          <div class="form-floating mb-3"> <!-- id 속성은 마크업당 1번만 가능 , class 속성은 마크업당 여러개 가능 , 띄어쓰기 구분 -->
	            <input type="text" class="form-control midinput" id="floatingInput1" placeholder="계정아이디">
	            <label for="floatingInput1">계정아이디</label>
	          </div>

	          <div class="form-floating mb-3">
	            <input type="password" class="form-control mpwdinput" id="floatingPassword1" placeholder="계정비밀번호">
	            <label for="floatingPassword1">계정비밀번호</label>
	          </div>
	          
	          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onLogin()">로그인</button>
	          <hr class="my-4">
	          <small class="text-body-secondary"><a class="nav-link" href="signup.jsp">회원가입</a></small>
	          <small class="text-body-secondary"><a class="nav-link" href="#">아이디 찾기</a></small>
	          <small class="text-body-secondary"><a class="nav-link" href="#">비밀번호 찾기</a></small>
	        </form>
	        
	      </div>
	    </div>
	  </div>	
	
		<script type="text/javascript" src="/tj2024_web1/js/member/login.js"></script>
	
</body>
</html>