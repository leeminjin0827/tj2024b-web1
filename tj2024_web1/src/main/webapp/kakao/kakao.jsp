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
	
	<div id="map" style="width:500px;height:400px;"></div>
	
	<button style="display : none;" class="btn btn-primary 사이드바" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
	  Button with data-bs-target
	</button>
	
	<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
	  <div class="offcanvas-header">
	    <h5 class="offcanvas-title" id="offcanvasExampleLabel">약국정보</h5>
	    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	  </div>
	  <div class=offcanvas-body">
	  	<div class="약국명"></div>
	  	<div class="전화번호"></div>
	  	<div class="주소"></div>
	  </div>
	</div>
	
	<!-- JQUERY 라이브러리 : 카카오지도에 필요한 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
	
	<!-- 
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f41f90a5a5fc00d38b00640ba24cc30c"></script>
	<script type="text/javascript">
	
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
	
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
	</script>
	 -->
	
	<script type="text/javascript" src="kakao.js"></script>
	
</body>
</html>