<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/day05/header.jsp"></jsp:include>

	<div>
		<h3> 게시물 작성 : 작성후 등록버튼을 클릭하세요! </h3>
		제목: <input class="titleInput" /> <br/>
		내용: <textarea class="contentInput" rows="10" cols="50"> </textarea> <br/>
		작성자: <input class="writerInput" /> <br/>
		비밀번호: <input class="passwordInput" /> <br/>
		<button onclick="boardWrite()" type="button"> 바튼 </button>
	</div>
	
	<script src="write.js"></script>
	
	<jsp:include page="/day05/footer.jsp"></jsp:include>

</body>
</html>