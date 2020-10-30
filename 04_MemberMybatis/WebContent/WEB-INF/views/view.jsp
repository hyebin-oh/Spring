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

아이디: ${member.id } <br>
비밀번호: ${member.pass } <br>
성명: ${member.name }<br>
주소: ${member.addr }<br>
메모: ${member.memo }<br>
작성일: ${member.reg_date }<br>
<br>
<input type="button" value="수정하기" onclick="location.href='update.my?id=${member.id}'">
<input type="button" value="삭제하기" onclick="location.href='delete.my?id=${member.id}'">
<br>
<input type="button" value="목록" onclick="location.href='list.my'">

</body>
</html>