<%@page import="project.vo.CustomerVo"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h3>모든 고객을 조회하여 출력하기</h3>
	<p>TblCustomerDao 메소드로 db접속 및 조회 결과 출력하는 연습입니다.</p>
	<hr>
	<% TblCustomerDao customerDao = new TblCustomerDao(); 
		
	%>
	
</body>
</html>