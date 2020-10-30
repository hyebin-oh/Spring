<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" id="id" name="id" value=${member.id } readonly></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" id="pass" name="pass" value=${member.pass }></td>
	</tr>
	<tr>
		<td>성명</td>
		<td><input type="text" id="name" name="name" value=${member.name }></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" id="addr" name="addr" value=${member.addr }></td>
	</tr>
	<tr>
		<td>메모</td>
		<td><textarea id="memo" name="memo" rows="8">${member.memo }</textarea></td>
	</tr>
	<tr>
		<td><input type="submit" value="수정완료"></td> 
	</tr>
</table>
</form>
</body>
</html>