<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>a태그의 url 주소에 파라미터 값을 포함해서 전송하기</h3>
	<p>이것은 메뉴 또는 조회 동작을 할때 사용되는 방식입니다.</p>
	<hr>
	<ul>
		<li><a href="5_param_receive.jsp?name=sana&age=24">name, age 2개의 파라미터 보내기</a></li>
		<!-- 두개의 값이 모두 출력  -->
		<li><a href="5_param_receive.jsp?name=sana"></a>name, age 2개의 파라미터 보내기 - age 파라미터 없을때</li>
		<!-- age는 null  -->
		<li><a href="5_param_receive.jsp?name=sana&age="></a>name,age 2개의 파라미터보내기 - age 값 없을때.</li>
		<!-- age는 length가 0인 문자열.  -->
		<!-- a 태그로 보내는 parameter의 값은 get 방식으로, 보안 방식에 취약하다는 단점을 가지고 있음. 따라서 페이지방식으로만 하는걸 추천,  -->
	</ul>
</body>
</html>