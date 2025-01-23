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
		<h3> 게시물 개별 수정 : 새로운 내용 하고 수정 버튼을 클릭하세요. </h3>
		<div>
			제목 : <input class="newT"/> <br/><br/>
			내용 : <textarea class="newC" rows="10" cols="50"> </textarea> <br/><br/>
			<button onclick="boardUpdate()"> 바튼 </button>
		</div>
	</div>
		
	<script src="update.js"></script>
	
	<jsp:include page="/day05/footer.jsp" />

</body>
</html>