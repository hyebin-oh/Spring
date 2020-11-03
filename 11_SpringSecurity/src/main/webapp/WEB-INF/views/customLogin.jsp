<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
	<form method="post" action="/security/login">
		<div>
			<input type="text" name="username">
		</div>
		<div>
			<input type="password" name="password">
		</div>
		<div>
			<input name="remember=me" type="checkbox">
			Remember Me 
		</div>
		<div>
			<input type="submit" >
		</div>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>

<script>
	$("#write").click(function(){
		
	})
</script>
</body>
</html>