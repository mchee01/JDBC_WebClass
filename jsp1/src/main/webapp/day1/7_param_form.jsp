<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>테이블 행 조회에 필요한 조건값을 input에 입력하고 전송하기.</h3>
	<hr>
	<form action="6_selectBy.jsp">
	<input type="text" name="" placeholder="이름을 입력하세요." required />
	<input type="number" name="" placeholder="나이를 입력하세요." required />
	<button>조회</button>
	<!-- 기본 type = submit. 클릭하면 action에 지정된 url로 전송됩니다. 실행한뒤 url 확인을 해보면 4번 실행 url과 같습니다.
		이유: <form> 안에 있는 method 속성이 지정을 안해줬을 경우 method="get"속성으로 지정되어있기 때문이다.
		get -> url로 값을 노출하면서 데이터 전송.
		
		1. 장점
		로딩이 빠름, 처리가 다소 쉬움. 페이지 처리에 용이.
		2. 단점
		보안에 취약함, 개인정보 유출의 위험이 있음.
		(스크립트에 접근하여 조작가능하다.)
		
		method="post" post 방식.
		url로 전송하지 않고 숨긴채 백도어로 전송한다.
		
		1. 장점
		보안취약점이 개선됨, url을 통한 데이터의 노출 or 변수 값의
	 -->
	</form>
</body>
</html>