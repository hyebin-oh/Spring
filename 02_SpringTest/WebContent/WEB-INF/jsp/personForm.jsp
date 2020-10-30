<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>개인 정보 입력</h2>
<form action="personInsert.go" method="post">
	<label for="name">이름:</label>
	<input type="text" id="name" name="name"><br>
	
	<label for="id">아이디:</label>
	<input type="text" id="userid" name="id"><br>
	
	<label for="password">패스워드:</label>
	<input type="text" id="password" name="password"><br>
	
	<label for="man">성별:</label>
	<input type="radio" name="gender" id="man" value="남" checked>남성
	<input type="radio" name="gender" id="woman" value="여">여성<br>
	
	<label for="job">직업:</label>
	<select id="job" name="job">
		<option value="회사원">회사원</option>
		<option value="학생">학생</option>
		<option value="기타">기타</option>
	</select><br>
	
	<input type="submit" value="확인" id="btnSubmit">
	<input type="reset" value="취소" id="btnReset">
	
</form>
</body>
</html>