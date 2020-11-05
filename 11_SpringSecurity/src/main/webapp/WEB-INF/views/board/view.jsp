<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>${board.writer } 게시글 보기</h1>
	
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	<input type="hidden" size="100" id="username" name="username"
	value='<sec:authentication property="principal.username"/>'>
	<input type="hidden" name ="num" id="num" value="${board.num }" >
  <div>
    <label for="writer">작성자:</label>
    <input type="text"  id="password" name="writer" value="${board.writer}" readonly>
  </div>

  <div>
    <label for="password">비밀번호:</label>
    <input type="text"  id="password" name="password" value="${board.password}" readonly>
  </div>
  
  <div>
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" value="${board.title}" readonly>
  </div>
  
  <div>
    <label for="content">내용:</label>
    <textarea rows="5" id="content" name="content" readonly>${board.content}</textarea>
  </div> 
  
  <div>
   <sec:authentication property="principal" var="user"/>
   <sec:authorize access="isAuthenticated()">
    <c:if test="${board.writer eq user.username}">
     <input type="button" value="수정하기" onclick="location.href='/security/board/update?num=${board.num }'">
    <input type="button" value="삭제하기" onclick="location.href='/security/board/delete?num=${board.num }'">
    </c:if>
   </sec:authorize>
  </div>
 
  <br>
  
  <div id="commentArea"></div>

  <div>
	<textarea rows="5" cols="40" name="comment" id="comment"></textarea>	
  	<input type="button" id="commentInsert" value="댓글등록">
  </div>
  
  <script>

    var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue = "${_csrf.token}";

	//Ajax spring security header...
	 $(document).ajaxSend(function(e, xhr, options){
		xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
		}) 
  
	$("#commentInsert").click(function(){
		var data={
			bnum:$("#num").val(),
			content:$("#comment").val(),
			userid:$("#username").val()
		}

		$.ajax({
			type:"post",
			url:"/security/reply/commentInsert",
			contentType:'application/json;charset=utf-8',
			data:JSON.stringify(data)
		})
		.done(function(){
			
			alert("성공");
		})
		.fail(function(){
			alert("error");
		})
		
	})
  </script>
   
</body>
</html>