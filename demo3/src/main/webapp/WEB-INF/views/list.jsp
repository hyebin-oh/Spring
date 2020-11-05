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
<h3>리스트</h3>
	<c:forEach items="${list}" var="list" >
		아이디: ${list.id }<br>
		이름: <a href="view?id=${list.id }">${list.name }</a><br>
		주소: ${list.addr }<br>
		<a href="${list.id }">상세보기</a><br>
		<br>
		<hr>
		<br>		
	</c:forEach>
</body>
</html>