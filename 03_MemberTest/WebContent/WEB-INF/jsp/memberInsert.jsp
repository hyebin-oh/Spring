<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원가입</h2>
<form action="member_insert.me" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" id="pass" name="pass"></td>
		</tr>
		<tr>
			<td>성명</td>
			<td><input type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" id="addr" name="addr"></td>
		</tr>
		<tr>
			<td>메모</td>
			<td><textarea id="memo" name="memo" rows="8"></textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="가입"></td> 
		</tr>
	</table>
</form>

</body>
</html>