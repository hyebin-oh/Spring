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
<h1>게시판 글쓰기</h1>
<a href="/security/board/list">게시글보기</a>
<form action="/security/board/insert" method="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	<input type="text" size="100" name="writer" id="username"
	value='<sec:authentication property="principal.username"/>'>

  <div>
    <label for="password">비밀번호:</label>
    <input type="text"  id="password" name="password">
  </div>
  
  <div>
    <label for="title">제목:</label>
    <input type="text" id="title" name="title">
  </div>
  
  <div>
    <label for="content">내용:</label>
    <textarea rows="5" id="content" name="content"></textarea>
  </div> 
  
  <input type="submit" value="제출">


</form>
</body>
</html>