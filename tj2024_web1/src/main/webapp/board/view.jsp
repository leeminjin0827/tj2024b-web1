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
	
	<div class="container">
	
		<div> 
			작성자 : <span class="midbox"> 작성자 구역 </span>
			조회수 : <span class="viewbox"> 조회수 구역 </span>
			작성일 : <span class="datebox"> 작성일 구역 </span>	
		</div> <br/><br/>
		
		<div style="text-align: center; font-size: 30px" class="titlebox">
			제목이 들어갈 구역 
		</div> <br/><br/>
		
		<div class="contentbox"> 본문이 들어갈 구역 </div>
		
		<div>
			<textarea class="rcontentinput from-control"></textarea> <!-- form-control : 부트스트링 css -->
			<button onclick="onReplyWrite()" type="button" class="btn btn-primary"> 댓글 게시 </button>
		</div>
		
		<div class="replybox mt-5">
			
		</div>
	
	</div>

	<script src="/tj2024_web1/js/board/view.js" type="text/javascript"></script>

</body>
</html>