<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] names = {"사나", "나연", "모모", "쯔위", "다현"};
	List<String> list = List.of("사나", "나연", "모모", "쯔위", "다현");
	CustomerVo vo = new CustomerVo("sana","김사나","sana@gmail.com", 23, null);
	%>
	<h4>배열 names</h4>
	<ul><!-- 여기에 names 배열 요소값을 자바코드 사용하여 반복문 출력  -->
	<%
	for(int i=0; i<names.length;i++){
%>  <li><%= names[i] %></li>
<%	} %>
	</ul>
	<hr>
	<h3>컬렉션</h3>
	<hr>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
			<th>가입날짜</th>
		</tr>
		<tr>
			<th><%= vo.getCustomId() %></th>
			<th><%= vo.getName() %></th>
			<th><%= vo.getEmail() %></th>
			<th><%= vo.getAge() %></th>
			<th><%= vo.getReg_date() %></th>
		</tr>
	</table>
<!-- 이클립스 단축키 : ctrl + d -> 한줄삭제 ctrl+alt+방향키 -> 한줄복사
		alt + 방향키 -> 줄이동 ctrl+shift+/ -> 주석
		shift+enter -> 다음줄 이동
		ctrl + space바(참조, import, 자동완성 등..)

 -->
</body>
</html>