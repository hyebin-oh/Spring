<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h3>${member.name } 상세조회</h3>

ID: <span id="id">${member.id }</span><br>
NAME: ${member.name }<br>
ADDRESS: ${member.addr }<br>
<br>

<input type="button" value="삭제버튼"  id="btnDelete">

<a href="delete?id=${member.id }">삭제 링크</a>

<script src="/js/member.js"></script>
</body>
</html>