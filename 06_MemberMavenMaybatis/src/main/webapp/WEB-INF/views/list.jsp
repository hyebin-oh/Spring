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

<c:forEach items="${list }" var="member">
아이디: <a href="view?id=${member.id }">${member.id } </a><br>
비밀번호: ${member.pass } <br>
성명: ${member.name }<br>
주소: ${member.addr }<br>
메모: ${member.memo }<br>
작성일: ${member.reg_date }<br>
<br>
</c:forEach>

<div align="left">
	<form action="list">
		<select name="field" id="field">
			<option value="name">이름</option>
			<option value="addr">주소</option>
		</select>
		<input type="text" name="word" id="word">
		<input type="submit" value="찾기" id="btnSearch">	
	</form>
</div>

</body>
</html>