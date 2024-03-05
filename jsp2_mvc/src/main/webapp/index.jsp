<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Front Controller test</h3>
<hr>
<P>url은 확장자가 없는 형식으로 만들기. 프로젝트에서 기능별로 폴더 생성.
jsp 파일을을 member, community, product folder(ex) 등에 저장을 합니다.
url도 하위 폴더를 갖는 형식으로 해야 편함()
</P>
<ul>
<li><a href="member/join">회원가입</a></li>
<li><a href="member/modify">회원정보 수정</a></li>
<li><a href="product/list">상품 목록</a></li>
<li><a href="community/list">커뮤니티(게시판)</a></li>
<li><a href="mypage">마이페이지</a></li>
<li><a href="cart">장바구니</a></li>
<li><a href="#">로그인</a></li>
</ul>
</body>
</html>