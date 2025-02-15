<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/tj2024_web1/css/member.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="/header.jsp" />

	<!-- 회원가입 폼 -->
	<div class="container col-xl-10 col-xxl-8 px-4 py-5">
	    <div class="row align-items-center g-lg-5 py-5">
	      <!--  수정 입력 구역 -->
	      <div class="col-md-10 mx-auto col-lg-5">
	        <form class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
	        
	          <div class="form-floating mb-3 mimgbox">
	            <img src="" class="mimg" />
	          </div>
	        
	          <!-- 아이디 -->
	          <div class="form-floating mb-3">
	            <input type="text" readonly name="mid" class="form-control mid" id="floatingInput1" placeholder="계정아이디">
	            <label for="floatingInput1">계정아이디</label>
	          </div>
	          <!-- 닉네임 -->
	          <div class="form-floating mb-3">
	            <input type="text" readonly name="mname" class="form-control mname" id="floatingInput2" placeholder="닉네임">
	            <label for="floatingInput2">닉네임</label>
	          </div>
	          <!-- 연락처 -->
	          <div class="form-floating mb-3">
	            <input type="text" readonly name="mphone" class="form-control mphone" id="floatingInput3" placeholder="연락처">
	            <label for="floatingInput3">연락처</label>
	          </div>
	          
	          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onUpdate()">수정</button>
	          <hr class="my-4">
	          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onDelete()">탈퇴</button>
	        </form>
	        
	      </div>
	      <div class="col-md-10 mx-auto col-lg-5">
	      	<table>
	      		<thead>
	      			<tr>
						<th>#</th><th>내역</th><th>수량</th><th>변경일</th>	      			
	      			</tr>
	      		</thead>
	      		<tbody>
	      			
	      		</tbody>
	      	</table>
	      </div>
	    </div>
	  </div>	
	
		<script type="text/javascript" src="/tj2024_web1/js/member/info.js"></script>
	
</body>
</html>