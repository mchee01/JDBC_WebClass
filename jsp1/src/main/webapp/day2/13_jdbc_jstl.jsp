<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>2번 소스파일 스크립트릿과 출력식을 jstl el로 변경하기</h3>
	<hr>
	<p>TblCustomerDao 메소드로 db접속 및 조회 결과 출력하는 연습.</p>
	<hr>
	<%
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVo> list = dao.allCustomers();
		pageContext.setAttribute("list", list);
	%>
	<table>
	<%
		for(CustomerVo vo : list){
	%>
		<tr>
		     <td><%= vo.getCustomId() %></td>
		     <td><%= vo.getName() %></td>
		     <td><%= vo.getEmail() %></td>
		     <td><%= vo.getEmail() %></td>
		     <td><%= vo.getReg_date() %></td>
		</tr>
<%} %>	
	</table>
</body>
</html>