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
<h2>${user.name }님의 정보</h2>

<form action="personUpdate" method="post">
	<label for="name">이름:${user.name }</label><br>
	
	<label for="id">아이디:${user.id }</label><br>
	
	<label for="man">성별:${user.gender }</label><br>
	
	<label for="job">직업:${user.job }</label><br>
	
	<input type="button" value="수정" onclick="location.href='personUpdate?id=${user.id }'">
	<input type="button" value="삭제" onclick="location.href='personDelete?id=${user.id}'">	
</form>
<input type="button" value="목록" onclick="location.href='personList'">

</body>
</html>