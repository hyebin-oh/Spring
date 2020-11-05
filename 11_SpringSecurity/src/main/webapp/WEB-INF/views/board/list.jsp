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
<h1>게시글 리스트</h1>
<table class="table table-striped">
    <thead>
      <tr>
        <th>NO(seq)</th>
        <th>작성자</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${list }" var="list">    
      <tr>
        <td>${list.num }</td>
        <td>${list.writer }</td>
        <td><a href="view?num=${list.num}">${list.title }</a></td>
        <td>${list.content }</td>
        <td>${list.regdate }</td>
        <td>${list.hitcount }</td>
      </tr>
     </c:forEach> 
    </tbody>
</table>

</body>
</html>