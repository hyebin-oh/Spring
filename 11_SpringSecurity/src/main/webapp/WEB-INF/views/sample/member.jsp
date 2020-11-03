<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/sample/member page</h1>
	<p> principal: <sec:authentication property="principal"/></p>
	<p>사용자아이디: <sec:authentication property="principal.username"/></p>
	
	<a href="/security/customLogout">로그아웃</a>
	
</body>
</html>