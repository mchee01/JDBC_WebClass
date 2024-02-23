<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL 태그 라이브러리 테스트</h3>
	<p>기존에 사용하던 jsp의 스크립트릿, 출력식 기호를 대체합니다.
	이유는 요청처리하는 자바코드와 화면을 구성하는 html 태그를 분리할때 jsp파일을 태그형식으로만 작성하기 위함입니다.
	</p>
	<p>태그 라이브러리는 맨 위 지시자에서 정의하고 사용합니다.
	</p>
	<hr>
	<h4>c: 로 시작하는 core 태그</h4>
	<c:set var="age" value="23"/> <!-- 저장된 애트리뷰트 값을 출력. -->
	<!-- 자바의 if문 대체 -->
	<h5>c:if 테스트</h5>
	<c:if test="${age < 20}">
		<div style="color:green">청소년입니다</div>
	</c:if>
	<c:if test="${age >= 20}">
		<div style="color:red">성인입니다.</div>
	</c:if>
	<h5>c:choose 테스트</h5>
	<c:choose>
		<c:when test="${age <20}">
			<div style="color:green">청소년 입니다.</div>
		</c:when>
		<c:otherwise>
			<div style="color:red">성인입니다.</div>
		</c:otherwise>
	</c:choose>
	<h5>c:forEach 테스트</h5>
	<c:forEach var="i" begin="1" end="10" varStatus="status">
		<c:out value="${i}"/>,
		<c:out value="${i*11}"/>,
		<c:out value="${status.index}"/>,
		<c:out value="${status.count}"/>
	</c:forEach>
</body>
</html>