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
	        <h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3"> 더조은 회원가입 </h1>
	        <p class="col-lg-10 fs-4">도망가</p>
	      </div>
	      
	      <!--  오른쪽 회원가입 입력 구역 -->
	      <div class="col-md-10 mx-auto col-lg-5">
	      
	        <form id="signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
	          <!-- 아이디 -->
	          <div class="form-floating mb-3">
	            <input type="text" name="mid" class="form-control" id="floatingInput1" placeholder="계정아이디">
	            <label for="floatingInput1">계정아이디</label>
	          </div>
	          <!-- 비밀번호 -->
	          <div class="form-floating mb-3">
	            <input type="password" name="mpwd" class="form-control" id="floatingPassword1" placeholder="계정비밀번호">
	            <label for="floatingPassword1">계정비밀번호</label>
	          </div>
	          <!-- 비밀번호 확인 -->
	          <div class="form-floating mb-3">
	            <input type="password" class="form-control" id="floatingPassword2" placeholder="계정비밀번호 확인">
	            <label for="floatingPassword2">계정비밀번호 확인</label>
	          </div>
	          <!-- 닉네임 -->
	          <div class="form-floating mb-3">
	            <input type="text" name="mname" class="form-control" id="floatingInput2" placeholder="닉네임">
	            <label for="floatingInput2">닉네임</label>
	          </div>
	          <!-- 연락처 -->
	          <div class="form-floating mb-3">
	            <input type="text" name="mphone" class="form-control" id="floatingInput3" placeholder="연락처">
	            <label for="floatingInput3">연락처</label>
	          </div>
	          <!-- 프로필 -->
	          <div class="form-floating mb-3">
	            <input type="file" name="uploadfile" class="form-control" id="floatingInput4" placeholder="프로필">
	            <label for="floatingInput4">프로필</label>
	          </div>
	          
	          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onSignUp()">가입</button>
	          <hr class="my-4">
	          <small class="text-body-secondary"><a class="nav-link" href="login.jsp">로그인</a></small>
	          <small class="text-body-secondary"><a class="nav-link" href="#">아이디 찾기</a></small>
	          <small class="text-body-secondary"><a class="nav-link" href="#">비밀번호 찾기</a></small>
	        </form>
	        
	      </div>
	    </div>
	  </div>	
	
		<script type="text/javascript" src="/tj2024_web1/js/member/signup.js"></script>
	
</body>
</html>