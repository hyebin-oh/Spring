<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board.writer } 게시글 보기</h1>
	<form action="/security/board/update" method="post">
	
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	<input type="hidden" size="100" id="username"
	value='<sec:authentication property="principal.username"/>'>
	<input type="hidden" name ="num" value="${board.num }"  >
  <div>
    <label for="writer">작성자:</label>
    <input type="text"  id="password" name="writer" value="${board.writer}">
  </div>

  <div>
    <label for="password">비밀번호:</label>
    <input type="text"  id="password" name="password" value="${board.password}" >
  </div>
  
  <div>
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" value="${board.title}" >
  </div>
  
  <div>
    <label for="content">내용:</label>
    <textarea rows="5" id="content" name="content" >${board.content}</textarea>
  </div> 
  
  <div>
  	<input type="submit" value="수정하기">
  </div>
</form>
  <br>


   
</body>
</html>