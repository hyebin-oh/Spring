<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>/sample/home page</h1>
	<sec:authorize access=" isAnonymous()">
		<a href="/security/customLogin">로그인</a>
		<a href="/security/board/insert">글쓰기</a>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<a href="/security/customLogout">로그아웃</a>
	</sec:authorize>
</body>
</html>
