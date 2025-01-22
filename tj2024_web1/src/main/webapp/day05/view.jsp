<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="/day05/header.jsp" />
	
	<div>
		<h3> 게시물 개별 조회 : 상세페이지로 선택한 특정 게시물을 조회 합니다. </h3>
		<div>
			작성일 : <span class="bdbox"></span> <br/>
			작성자 : <span class="bwbox"></span> <br/>
			조회수 : <span class="bvbox"></span> <br/>
		</div>
		제목
		<div class="btbox"></div>
		내용
		<div class="bcbox"></div>
		<br/>
		<div class="etcbtns">
			<button onclick="boardDelete()">삭제</button>
			<button onclick="boardUpdate()">수정</button>
		</div>
	</div>
	
	<script src="view.js"></script>
	
	<jsp:include page="/day05/footer.jsp" />
	
</body>
</html>