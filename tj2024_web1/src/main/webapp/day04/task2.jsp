<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> (식당)대기번호 발행 프로그램2</h2>
	<div>
		<div> 순번등록 </div>
		전화번호 : <input class="pInput"/> <br/>
		인원수 : <input class="nInput"/> <br/>
		<button onclick="visitWrite()" type="button"> 등록 </button>
	</div>
	<div>
		<div> 대기 목록 </div>
		<table border="1">
			<thead>
				<tr>
					<th> 순번 </th>
					<th class="p"> 전화번호 </th>
					<th> 인원수 </th>
					<th> etc </th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>


	<script src="task2.js"></script>

</body>
</html>