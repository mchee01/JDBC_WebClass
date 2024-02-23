<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>자바 객체 컬렉션(리스트) 활용하기</h5>
	<%
	CustomerVo vo = new CustomerVo("momo22", "강모모", "momo22@daum.net",29,null);
	
	List<CustomerVo> list = List.of(
	new CustomerVo("momo12","강모모","momo@daum.net",29,null),
	new CustomerVo("momo13","강모모","momo@daum.net",29,null),
	new CustomerVo("momo14","강모모","momo@daum.net",29,null),
	new CustomerVo("momo15","강모모","momo@daum.net",29,null),
	new CustomerVo("momo16","강모모","momo@daum.net",29,null)
	);
	
	pageContext.setAttribute("list",list);
	%>
	<c:forEach items="${list}" var="vo" varStatus="status">
		<c:out value="${status.index }"/>,<c:out value="${vo}"/>
		<ul>
		<li><c:out value="${vo.customId}"></c:out></li>
		<li><c:out value="${vo.name}"></c:out></li>
		<li><c:out value="${vo.email}"></c:out></li>
		<li><c:out value="${vo.age}"></c:out></li>
		</ul>
	</c:forEach>
</body>
</html>